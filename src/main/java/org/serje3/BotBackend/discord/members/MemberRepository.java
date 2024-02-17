package org.serje3.BotBackend.discord.members;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.serje3.BotBackend.domain.GuildId;
import org.serje3.BotBackend.domain.Member;
import org.serje3.BotBackend.domain.UserId;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import static com.serje3.generated.jooq.Tables.MEMBERS;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final DSLContext dsl;

    public Member get(Integer id) {
        return dsl.selectFrom(MEMBERS)
                .where(MEMBERS.ID.eq(id))
                .fetchOneInto(Member.class);
    }

    public Member.Ref get(UserId userId, GuildId guildId) {
        return dsl.selectFrom(MEMBERS)
                .where(MEMBERS.USER_ID.eq(userId.getValue()),
                        MEMBERS.GUILD_ID.eq(guildId.getValue()))
                .fetchOneInto(Member.Ref.class);
    }

    public void update(Member member) {
        dsl.update(MEMBERS)
                .set(MEMBERS.EFFECTIVE_USERNAME, member.getEffectiveUsername())
                .where(MEMBERS.USER_ID.eq(member.getUserId().getValue()),
                        MEMBERS.GUILD_ID.eq(member.getGuildId().getValue()))
                .execute();
    }

    public void create(Member member) throws DuplicateKeyException {
        dsl.insertInto(MEMBERS)
                .set(MEMBERS.USER_ID, member.getUserId().getValue())
                .set(MEMBERS.GUILD_ID, member.getGuildId().getValue())
                .set(MEMBERS.EFFECTIVE_USERNAME, member.getEffectiveUsername())
                .set(MEMBERS.IS_ADMIN, false)
                .execute();
    }
}
