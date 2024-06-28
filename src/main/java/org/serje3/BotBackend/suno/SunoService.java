package org.serje3.BotBackend.suno;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.suno.data.SunoAuth;
import org.serje3.BotBackend.suno.data.SunoClip;
import org.serje3.BotBackend.suno.data.SunoGenerateRequest;
import org.serje3.BotBackend.suno.data.SunoGenerateResponse;
import org.serje3.BotBackend.suno.exceptions.FailedRetrieveToken;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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


    public SunoGenerateResponse generate(Long userId, SunoGenerateRequest request) throws FailedRetrieveToken {
        String token = getToken(userId);

        HttpHeaders headers = new HttpHeaders() {{
            add("Authorization", "Bearer " + token);
        }};

        HttpEntity<SunoGenerateRequest> entity = new HttpEntity<>(request, headers);

        String generateUrl = sunoBackendBaseUrl + "generate";

        ResponseEntity<SunoGenerateResponse> resp = restTemplate.exchange(generateUrl, HttpMethod.POST, entity, SunoGenerateResponse.class);

        return resp.getBody();
    }

    public List<SunoClip> feed(Long userId) {
        String token = getToken(userId);

        HttpHeaders headers = new HttpHeaders() {{
            add("Authorization", "Bearer " + token);
        }};

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String generateUrl = sunoBackendBaseUrl + "feed/";

        ResponseEntity<List<SunoClip>> resp = restTemplate.exchange(generateUrl,
                HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<SunoClip>>() {});

        return resp.getBody();
    }
}
