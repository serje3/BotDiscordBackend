package org.serje3.BotBackend.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class EventLog {
    private final EventLogType type;
    private final String name;
    private final String description;
    private final GuildId guildId;
    private final UserId senderId;

    @Getter
    @RequiredArgsConstructor
    public static class Ref {
        private final Integer id;
        private final EventLogType type;
        private final String name;
        private final String description;
        private final GuildId guildId;
        private final UserId senderId;
        private final LocalDateTime emittedAt;
    }


    @Getter
    @RequiredArgsConstructor
    public static class RatingRef {
        private final Integer rank;
        private final Long senderId;
        private final Integer count;
    }
}
