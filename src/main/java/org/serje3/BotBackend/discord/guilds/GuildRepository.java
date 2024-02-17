package org.serje3.BotBackend.discord.guilds;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.serje3.BotBackend.domain.Guild;
import org.serje3.BotBackend.domain.GuildId;
import org.serje3.BotBackend.domain.Guild;
import org.serje3.BotBackend.domain.UserId;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import static com.serje3.generated.jooq.Tables.GUILD;
import static com.serje3.generated.jooq.Tables.GUILD;

@Repository
@RequiredArgsConstructor
public class GuildRepository {
    private final DSLContext dsl;

    public Guild.Ref getById(Integer id) {
        return dsl.selectFrom(GUILD)
                .where(GUILD.ID.eq(id))
                .fetchOneInto(Guild.Ref.class);
    }

    public Guild.Ref get(GuildId guildId) {
        return dsl.selectFrom(GUILD)
                .where(GUILD.GUILD_ID.eq(guildId.getValue()))
                .fetchOneInto(Guild.Ref.class);
    }

    public void update(Guild guild) {
        dsl.update(GUILD)
                .set(GUILD.NAME, guild.getName())
                .set(GUILD.ICON_URL, guild.getIconUrl())
                .set(GUILD.OWNER_ID, guild.getOwnerId().getValue())
                .where(GUILD.GUILD_ID.eq(guild.getGuildId().getValue()))
                .execute();
    }

    public void create(Guild guild) throws DuplicateKeyException {
        dsl.insertInto(GUILD)
                .set(GUILD.OWNER_ID, guild.getOwnerId().getValue())
                .set(GUILD.GUILD_ID, guild.getGuildId().getValue())
                .set(GUILD.NAME, guild.getName())
                .set(GUILD.ICON_URL, guild.getIconUrl())
                .execute();
    }
}
