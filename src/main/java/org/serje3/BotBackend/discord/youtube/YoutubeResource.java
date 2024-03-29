package org.serje3.BotBackend.discord.youtube;

import io.sentry.Hint;
import io.sentry.Sentry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("youtube")
@RequiredArgsConstructor
public class YoutubeResource {
    private final YoutubeService youtubeService;

    @GetMapping("search")
    public ResponseEntity<?> search(@RequestParam("q") @NonNull String q) throws GeneralSecurityException, IOException {
        return ResponseEntity.ok(youtubeService.search(q));
    }


    @GetMapping("message")
    public ResponseEntity<?> message(String text){
        try {
            int x = 23 / 0;
        } catch (Exception e) {
            Sentry.captureMessage(text);
        }
        return ResponseEntity.ok().build();
    }
}
