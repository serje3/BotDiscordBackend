package org.serje3.BotBackend.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class Guild {
    private final GuildId guildId;
    private final UserId ownerId;
    private final String name;
//    private final Role botRole;
//    private final Channel systemChannel;
    private final String iconUrl;

    @Getter
    @RequiredArgsConstructor
    public static class Ref {
        private final Long id;
        private final UserId ownerId;
        private final GuildId guildId;
        private final String name;
        private final String iconUrl;
        private final LocalDateTime joinDate;
    }
}
