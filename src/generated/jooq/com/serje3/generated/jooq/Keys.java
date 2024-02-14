/*
 * This file is generated by jOOQ.
 */
package com.serje3.generated.jooq;


import com.serje3.generated.jooq.tables.Members;
import com.serje3.generated.jooq.tables.records.MembersRecord;

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

    public static final UniqueKey<MembersRecord> MEMBERS_PKEY = Internal.createUniqueKey(Members.MEMBERS, DSL.name("members_pkey"), new TableField[] { Members.MEMBERS.ID }, true);
    public static final UniqueKey<MembersRecord> UNIQUE_USER_GUILD_PAIR = Internal.createUniqueKey(Members.MEMBERS, DSL.name("unique_user_guild_pair"), new TableField[] { Members.MEMBERS.USER_ID, Members.MEMBERS.GUILD_ID }, true);
}
