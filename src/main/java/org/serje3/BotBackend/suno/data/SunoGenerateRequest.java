package org.serje3.BotBackend.suno.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SunoGenerateRequest {
    private final String prompt;
    private final String mv;
    private final String title;
    private final String tags;
}
