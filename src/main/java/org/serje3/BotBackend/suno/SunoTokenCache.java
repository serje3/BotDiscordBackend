package org.serje3.BotBackend.suno;


import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.suno.data.SunoAuth;
import org.serje3.BotBackend.suno.data.SunoClientResponse;
import org.serje3.BotBackend.suno.data.SunoRetrieveTokenResponse;
import org.serje3.BotBackend.utils.CookieFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Nullable;
import java.net.CookiePolicy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.net.CookieManager;


@Service
public class SunoTokenCache {
    private final ConcurrentHashMap<Long, String> tokens = new ConcurrentHashMap<>();
    private final CookieManager cookieManager = new CookieManager();
    private final RestTemplate restTemplate;

    {
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
    }

    private final String baseUrl = "https://clerk.suno.com/v1/client/sessions/%s/tokens?_clerk_js_version=4.73.4";
    //    private final String baseUrl = "https://clerk.suno.com/v1/client?_clerk_js_version=4.73.4";
    private final HttpHeaders commonHeaders = new HttpHeaders() {
        {
            add("Content-Type", "text/plain;charset=UTF-8");
            add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36");
            add("Referer", "https://suno.com");
            add("Origin", "https://suno.com");
        }
    };

    private final SunoRepository sunoRepository;
    private final Logger logger = LoggerFactory.getLogger(SunoTokenCache.class);

    public SunoTokenCache(SunoRepository sunoRepository,
                          @Qualifier("proxied") RestTemplate restTemplate
    ) {
        this.sunoRepository = sunoRepository;
        this.restTemplate = restTemplate;
    }

    public String getSessionUrl(String sessionId) {
        return String.format(baseUrl, sessionId);
//        return baseUrl;
    }


    public String getTokenByUserId(Long userId) {
        return tokens.computeIfAbsent(userId, (uId) -> requestTokenByUserId(userId));
    }

    @Nullable
    private String requestTokenByUserId(Long userId) {
        SunoAuth auth = sunoRepository.getAuthByUserId(userId);
        if (auth == null) {
            logger.warn("Skipping token update for {}", userId);
            return null;
        }
        String url = getSessionUrl(auth.session());


        HttpHeaders headers = new HttpHeaders() {{
            addAll(commonHeaders);
            add("cookie", auth.cookie());
        }};

        HttpEntity<String> entity = new HttpEntity<>(headers);
        try {
            ResponseEntity<SunoRetrieveTokenResponse> resp = restTemplate
                    .exchange(url, HttpMethod.POST, entity, SunoRetrieveTokenResponse.class);
            if (resp.getStatusCode().is2xxSuccessful()) {
                handleSetCookie(auth, resp.getHeaders().get("Set-Cookie"));
                return resp.getBody().jwt();
//                Optional<SunoClientResponse.Session> session = Objects.requireNonNull(resp.getBody()).getResponse().getSessions().stream().findFirst();
//                if (session.isPresent()) {
//                    String jwt = session.get().getLastActiveToken().getJwt();
//                    logger.info("Updated token for user {} {}", userId, jwt);
//                    return jwt;
//                } else {
//                    logger.warn("No session present for {}", userId);
//                    logger.info(resp.toString());
//                }
            }
            return null;
        } catch (HttpClientErrorException e) {
            // Handle 4xx errors
            logger.error("Client error: {} - {}", e.getStatusCode(), e.getResponseBodyAsString());

            return null;
        } catch (HttpServerErrorException e) {
            // Handle 5xx errors
            logger.error("Server error: {} - {}", e.getStatusCode(), e.getResponseBodyAsString());
            return null;
        } catch (RestClientException e) {
            // Handle other errors
            logger.error("Error: {}", e.getMessage());
            return null;
        }
    }


    private void handleSetCookie(SunoAuth auth, List<String> cookies) {
        String oldCookies = auth.cookie();
        String newCookies = CookieFormatter.formatCookies(cookies);
        String mergedCookies = CookieFormatter.mergeCookies(oldCookies, newCookies);
        logger.info("Merged cookies: {} \nOld Cookies {}, \nNew Cookies {}", mergedCookies, oldCookies, newCookies);
        sunoRepository.updateAuth(new SunoAuth(auth.userId(), mergedCookies, auth.session()));
    }

    @Scheduled(fixedRate = 60000)
    public void updateToken() {
        for (Long userId : tokens.keySet()) {
            logger.info("User {} updating", userId);
            if (!updateTokenByUserId(userId)) {
                logger.warn("UPDATE NOT SUCCESS, REMOVING userId");
            }
        }
    }

    public boolean updateTokenByUserId(Long userId) {
        String token = requestTokenByUserId(userId);
        if (token != null) {
            tokens.put(userId, token);
            return true;
        } else {
            sunoRepository.deleteAuth(userId);
            tokens.remove(userId);
            return false;
        }
    }
}
