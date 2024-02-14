package org.serje3.BotBackend.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Member {
    private final UserId userId;
    private final GuildId guildId;

    private final String effectiveUsername;
}
