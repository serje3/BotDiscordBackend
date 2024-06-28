package org.serje3.BotBackend.suno.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public record SunoRetrieveTokenResponse(String object, String jwt) {
}
