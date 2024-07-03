package org.serje3.BotBackend.suno.data;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SunoCredits {
    @JsonAlias("credits_left")
    private final Integer creditsLeft;
    private final Integer period;
    @JsonAlias("monthly_limit")
    private final Integer monthlyLimit;
    @JsonAlias("monthly_usage")
    private final Integer monthlyUsage;
}
