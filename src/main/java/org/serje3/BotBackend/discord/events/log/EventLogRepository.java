package org.serje3.BotBackend.discord.events.log;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.serje3.BotBackend.domain.EventLog;
import org.serje3.BotBackend.domain.Guild;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import static com.serje3.generated.jooq.Tables.EVENT_LOG;
import static com.serje3.generated.jooq.Tables.GUILD;

@Repository
@RequiredArgsConstructor
public class EventLogRepository {
    private final DSLContext dsl;

    public void create(EventLog eventLog) throws DuplicateKeyException {
        dsl.insertInto(EVENT_LOG)
                .set(EVENT_LOG.TYPE, eventLog.getType().name())
                .set(EVENT_LOG.NAME, eventLog.getName())
                .set(EVENT_LOG.DESCRIPTION, eventLog.getDescription())
                .set(EVENT_LOG.GUILD_ID, eventLog.getGuildId().getValue())
                .set(EVENT_LOG.SENDER_ID, eventLog.getSenderId() != null ? eventLog.getSenderId().getValue(): null)
                .execute();
    }
}
