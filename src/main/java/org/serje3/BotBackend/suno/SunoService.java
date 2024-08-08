package org.serje3.BotBackend.suno;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.suno.data.*;
import org.serje3.BotBackend.suno.exceptions.FailedRetrieveToken;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SunoService {
    private final String sunoBackendBaseUrl = "http://localhost:8000/";
    private final SunoRepository repository;
    private final SunoTokenCache tokenCache;
    private final RestTemplate restTemplate;

    public void login(SunoAuth auth) {
        SunoAuth existedAuth = repository.getAuthByUserId(auth.userId());
        if (existedAuth == null) {
            repository.insertAuth(auth);
        } else {
            repository.updateAuth(auth);
        }

        if (!tokenCache.updateTokenByUserId(auth.userId())){ // if not success updated
            throw new FailedRetrieveToken("Failed to authenticate user");
        }
    }


    public SunoGenerateResponse generate(Long userId, SunoGenerateRequest request) throws FailedRetrieveToken {
        HttpHeaders headers = getAuthorizationHeader(userId);


        HttpEntity<SunoGenerateRequest> entity = new HttpEntity<>(request, headers);

        String generateUrl = sunoBackendBaseUrl + "generate";

        ResponseEntity<SunoGenerateResponse> resp = restTemplate.exchange(generateUrl, HttpMethod.POST, entity, SunoGenerateResponse.class);

        return resp.getBody();
    }

    public List<SunoClip> feed(Long userId, Optional<Integer> page) {
        HttpHeaders headers = getAuthorizationHeader(userId);


        HttpEntity<String> entity = new HttpEntity<>(headers);
        String feedUrl = sunoBackendBaseUrl + "feed/";

        if (page.isPresent()) {
            feedUrl = feedUrl + "?page=" + page.get();
        }

        ResponseEntity<List<SunoClip>> resp = restTemplate.exchange(feedUrl,
                HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<SunoClip>>() {
                });

        return resp.getBody();
    }

    public SunoCredits credits(Long userId) {
        HttpHeaders headers = getAuthorizationHeader(userId);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        String creditsUrl = sunoBackendBaseUrl + "get_credits/";

        ResponseEntity<SunoCredits> resp = restTemplate.exchange(creditsUrl,
                HttpMethod.GET, entity, SunoCredits.class);
        return resp.getBody();
    }

    private HttpHeaders getAuthorizationHeader(Long userId) {
        String token = getToken(userId);

        return new HttpHeaders() {{
            add("Authorization", "Bearer " + token);
        }};
    }


    private String getToken(Long userId) throws FailedRetrieveToken {
        SunoAuth auth = repository.getAuthByUserId(userId);
        if (auth == null) {
            throw new FailedRetrieveToken("Not logged in");
        }

        String token = tokenCache.getTokenByUserId(userId);

        if (token == null) {
            throw new FailedRetrieveToken("Token not retrieved");
        }

        return token;
    }
}
