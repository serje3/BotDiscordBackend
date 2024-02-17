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
}
