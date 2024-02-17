/*
 * This file is generated by jOOQ.
 */
package com.serje3.generated.jooq;


import com.serje3.generated.jooq.tables.EventLog;
import com.serje3.generated.jooq.tables.Guild;
import com.serje3.generated.jooq.tables.Members;
import com.serje3.generated.jooq.tables.records.EventLogRecord;
import com.serje3.generated.jooq.tables.records.GuildRecord;
import com.serje3.generated.jooq.tables.records.MembersRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<EventLogRecord> EVENT_LOG_PKEY = Internal.createUniqueKey(EventLog.EVENT_LOG, DSL.name("event_log_pkey"), new TableField[] { EventLog.EVENT_LOG.ID }, true);
    public static final UniqueKey<GuildRecord> GUILD_GUILD_ID_KEY = Internal.createUniqueKey(Guild.GUILD, DSL.name("guild_guild_id_key"), new TableField[] { Guild.GUILD.GUILD_ID }, true);
    public static final UniqueKey<GuildRecord> GUILD_PKEY = Internal.createUniqueKey(Guild.GUILD, DSL.name("guild_pkey"), new TableField[] { Guild.GUILD.ID }, true);
    public static final UniqueKey<MembersRecord> MEMBERS_PKEY = Internal.createUniqueKey(Members.MEMBERS, DSL.name("members_pkey"), new TableField[] { Members.MEMBERS.ID }, true);
    public static final UniqueKey<MembersRecord> UNIQUE_USER_GUILD_PAIR = Internal.createUniqueKey(Members.MEMBERS, DSL.name("unique_user_guild_pair"), new TableField[] { Members.MEMBERS.USER_ID, Members.MEMBERS.GUILD_ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<EventLogRecord, GuildRecord> EVENT_LOG__EVENT_LOG_GUILD_ID_FKEY = Internal.createForeignKey(EventLog.EVENT_LOG, DSL.name("event_log_guild_id_fkey"), new TableField[] { EventLog.EVENT_LOG.GUILD_ID }, Keys.GUILD_GUILD_ID_KEY, new TableField[] { Guild.GUILD.GUILD_ID }, true);
}
