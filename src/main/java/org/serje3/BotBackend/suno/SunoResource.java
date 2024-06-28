package org.serje3.BotBackend.suno;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.suno.data.SunoAuth;
import org.serje3.BotBackend.suno.data.SunoGenerateRequest;
import org.serje3.BotBackend.suno.exceptions.FailedRetrieveToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("suno")
@RequiredArgsConstructor
public class SunoResource {
    private final SunoService service;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody SunoAuth request) {
        service.login(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("generate")
    public ResponseEntity<?> generate(
            @RequestParam Long userId,
            @RequestBody SunoGenerateRequest request) {
        try {
            return ResponseEntity.ok(service.generate(userId, request));
        } catch (FailedRetrieveToken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("feed")
    public ResponseEntity<?> feed(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok(service.feed(userId));
        } catch (FailedRetrieveToken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
