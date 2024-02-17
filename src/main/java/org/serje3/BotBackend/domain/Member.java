package org.serje3.BotBackend.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class Member {
    private final UserId userId;
    private final GuildId guildId;
    private final String effectiveUsername;

    @Getter
    @RequiredArgsConstructor
    public static class Ref {
        private final Long id;
        private final UserId userId;
        private final GuildId guildId;
        private final String effectiveUsername;
        private final boolean isAdmin;
        private final LocalDateTime joinDate;
    }
}
