package org.serje3.BotBackend.suno;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.suno.data.SunoAuth;
import org.serje3.BotBackend.suno.data.SunoGenerateRequest;
import org.serje3.BotBackend.suno.exceptions.FailedRetrieveToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("feed/{userId}")
    public ResponseEntity<?> feed(@PathVariable Long userId, @RequestParam(required = false) Optional<Integer> page) {
        try {
            return ResponseEntity.ok(service.feed(userId, page));
        } catch (FailedRetrieveToken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("credits/{userId}")
    public ResponseEntity<?> credits(@PathVariable Long userId) {
        try {
            return ResponseEntity.ok(service.credits(userId));
        } catch (FailedRetrieveToken e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
