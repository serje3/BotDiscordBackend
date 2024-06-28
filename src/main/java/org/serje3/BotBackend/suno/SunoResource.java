package org.serje3.BotBackend.suno;

import org.serje3.BotBackend.suno.data.SunoLoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("suno")
public class SunoResource {
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody SunoLoginRequest request) {
        System.out.println(request.userId() + " " + request.cookie() + " " + request.session());

        return ResponseEntity.ok(true);
    }
}
