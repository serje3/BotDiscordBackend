package org.serje3.BotBackend.suno;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.suno.data.SunoAuth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
