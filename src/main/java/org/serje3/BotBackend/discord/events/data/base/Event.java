package org.serje3.BotBackend.discord.events.data.base;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.domain.GuildId;

@RequiredArgsConstructor
public class Event {
    private final GuildId guildId;
}
