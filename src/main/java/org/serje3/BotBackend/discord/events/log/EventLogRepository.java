package org.serje3.BotBackend.discord.events.log;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.SelectSeekStep1;
import org.serje3.BotBackend.domain.EventLog;
import org.serje3.BotBackend.domain.EventLogType;
import org.serje3.BotBackend.domain.UserId;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.serje3.generated.jooq.Tables.EVENT_LOG;
import static org.jooq.impl.DSL.count;
import static org.jooq.impl.DSL.rowNumber;

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
                .set(EVENT_LOG.SENDER_ID, eventLog.getSenderId() != null ? eventLog.getSenderId().getValue() : null)
                .execute();
    }


    public List<EventLog.Ref> getBySenderIdAndType(UserId senderId, EventLogType type) {
        return dsl.selectFrom(EVENT_LOG)
                .where(EVENT_LOG.SENDER_ID.eq(senderId.getValue()),
                        EVENT_LOG.TYPE.eq(type.name()))
                .orderBy(EVENT_LOG.EMITTED_AT.desc())
                .fetchInto(EventLog.Ref.class);
    }


    public List<EventLog.Ref> getByType(EventLogType type) {
        return dsl.selectFrom(EVENT_LOG)
                .where(EVENT_LOG.TYPE.eq(type.name()))
                .orderBy(EVENT_LOG.EMITTED_AT.desc())
                .fetchInto(EventLog.Ref.class);
    }

    public List<EventLog.RatingRef> getRatingOnSenders(EventLogType type) {
        Field<Integer> senderCount = count().as("sender_count");
        Field<Integer> rank = rowNumber().over().as("rank");

        SelectSeekStep1<Record2<Long, Integer>, Integer> ratingWithoutRank = dsl
                .select(
                        EVENT_LOG.SENDER_ID,
                        senderCount)
                .from(EVENT_LOG)
                .where(EVENT_LOG.TYPE.eq(type.name()),
                        EVENT_LOG.SENDER_ID.ne(263430624080035841L)) // it's me :)
                .groupBy(EVENT_LOG.SENDER_ID)
                .orderBy(count().desc());

        return dsl.select(
                        rank,
                        ratingWithoutRank.field("sender_id"),
                        ratingWithoutRank.field("sender_count"))
                .from(ratingWithoutRank)
                .orderBy(rank.asc())
                .fetchInto(EventLog.RatingRef.class);
    }
}
