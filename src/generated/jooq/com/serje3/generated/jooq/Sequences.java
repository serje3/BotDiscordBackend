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
     * The sequence <code>members_id_seq</code>
     */
    public static final Sequence<Integer> MEMBERS_ID_SEQ = Internal.createSequence("members_id_seq", DefaultSchema.DEFAULT_SCHEMA, SQLDataType.INTEGER.nullable(false), null, null, null, null, false, null);
}
