/*
 * This file is generated by jOOQ.
 */
package com.serje3.generated.jooq;


import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in the default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>event_log_id_seq</code>
     */
    public static final Sequence<Integer> EVENT_LOG_ID_SEQ = Internal.createSequence("event_log_id_seq", DefaultSchema.DEFAULT_SCHEMA, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>guild_id_seq</code>
     */
    public static final Sequence<Integer> GUILD_ID_SEQ = Internal.createSequence("guild_id_seq", DefaultSchema.DEFAULT_SCHEMA, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>members_id_seq</code>
     */
    public static final Sequence<Integer> MEMBERS_ID_SEQ = Internal.createSequence("members_id_seq", DefaultSchema.DEFAULT_SCHEMA, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>youtube_search_query_cache_id_seq</code>
     */
    public static final Sequence<Integer> YOUTUBE_SEARCH_QUERY_CACHE_ID_SEQ = Internal.createSequence("youtube_search_query_cache_id_seq", DefaultSchema.DEFAULT_SCHEMA, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);

    /**
     * The sequence <code>youtube_search_response_cache_id_seq</code>
     */
    public static final Sequence<Integer> YOUTUBE_SEARCH_RESPONSE_CACHE_ID_SEQ = Internal.createSequence("youtube_search_response_cache_id_seq", DefaultSchema.DEFAULT_SCHEMA, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);
}
