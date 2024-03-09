package org.serje3.BotBackend.discord.youtube;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
@RequiredArgsConstructor
public class YoutubeAPIService {
    private final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    @Value("${youtube.api-key}")
    private String API_KEY;

    /**
     * Build and return an authorized API client service.
     *
     * @return an authorized API client service
     * @throws GeneralSecurityException, IOException
     */
    public YouTube get() throws GeneralSecurityException, IOException {
        NetHttpTransport transport = new NetHttpTransport.Builder().build();
        HttpRequestInitializer httpRequestInitializer = request -> {
            request.setInterceptor(intercepted -> intercepted.getUrl().set("key", API_KEY));
        };
        String APPLICATION_NAME = "Captain Cocker";
        return new YouTube.Builder(transport, JSON_FACTORY, httpRequestInitializer)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
}
