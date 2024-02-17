package org.serje3.BotBackend.discord.guilds;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.domain.Guild;
import org.serje3.BotBackend.domain.GuildId;
import org.serje3.BotBackend.domain.Member;
import org.serje3.BotBackend.domain.UserId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GuildService {
    private final GuildRepository guildRepository;

    public Guild.Ref get(GuildId guildId) {
        return guildRepository.get(guildId);
    }
    @Transactional
    public void save(Guild guild) {
        Guild.Ref existingGuild = get(guild.getGuildId());
        if (existingGuild != null) {
            guildRepository.update(guild);
        } else {
            guildRepository.create(guild);
        }
    }
}
