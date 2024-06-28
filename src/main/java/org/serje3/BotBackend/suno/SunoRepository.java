package org.serje3.BotBackend.suno;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.serje3.BotBackend.suno.data.SunoAuth;
import org.springframework.stereotype.Repository;

import static com.serje3.generated.jooq.Tables.SUNO_LOGIN;

@Repository
@RequiredArgsConstructor
public class SunoRepository {
    private final DSLContext dsl;

    public SunoAuth getAuthByUserId(Long userId) {
        return dsl.selectFrom(SUNO_LOGIN).where(SUNO_LOGIN.USER_ID.eq(userId)).fetchOneInto(SunoAuth.class);
    }

    public void insertAuth(SunoAuth auth) {
        dsl.insertInto(SUNO_LOGIN)
                .set(SUNO_LOGIN.USER_ID, auth.userId())
                .set(SUNO_LOGIN.COOKIE, auth.cookie())
                .set(SUNO_LOGIN.SESSION_ID, auth.session())
                .execute();
    }

    public void updateAuth(SunoAuth auth) {
        dsl.update(SUNO_LOGIN)
                .set(SUNO_LOGIN.COOKIE, auth.cookie())
                .set(SUNO_LOGIN.SESSION_ID, auth.session())
                .where(SUNO_LOGIN.USER_ID.eq(auth.userId()))
                .execute();
    }
}
