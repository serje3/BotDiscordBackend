package org.serje3.BotBackend.suno.data;

public record SunoLoginRequest(Long userId, String cookie, String session) {
}
