/*
 * This file is generated by jOOQ.
 */
package com.serje3.generated.jooq.tables;


import com.serje3.generated.jooq.DefaultSchema;
import com.serje3.generated.jooq.Keys;
import com.serje3.generated.jooq.tables.records.YoutubeSearchQueryCacheRecord;

import java.time.LocalDateTime;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class YoutubeSearchQueryCache extends TableImpl<YoutubeSearchQueryCacheRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>youtube_search_query_cache</code>
     */
    public static final YoutubeSearchQueryCache YOUTUBE_SEARCH_QUERY_CACHE = new YoutubeSearchQueryCache();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<YoutubeSearchQueryCacheRecord> getRecordType() {
        return YoutubeSearchQueryCacheRecord.class;
    }

    /**
     * The column <code>youtube_search_query_cache.id</code>.
     */
    public final TableField<YoutubeSearchQueryCacheRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>youtube_search_query_cache.query</code>.
     */
    public final TableField<YoutubeSearchQueryCacheRecord, String> QUERY = createField(DSL.name("query"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>youtube_search_query_cache.executed_at</code>.
     */
    public final TableField<YoutubeSearchQueryCacheRecord, LocalDateTime> EXECUTED_AT = createField(DSL.name("executed_at"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    private YoutubeSearchQueryCache(Name alias, Table<YoutubeSearchQueryCacheRecord> aliased) {
        this(alias, aliased, null);
    }

    private YoutubeSearchQueryCache(Name alias, Table<YoutubeSearchQueryCacheRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>youtube_search_query_cache</code> table reference
     */
    public YoutubeSearchQueryCache(String alias) {
        this(DSL.name(alias), YOUTUBE_SEARCH_QUERY_CACHE);
    }

    /**
     * Create an aliased <code>youtube_search_query_cache</code> table reference
     */
    public YoutubeSearchQueryCache(Name alias) {
        this(alias, YOUTUBE_SEARCH_QUERY_CACHE);
    }

    /**
     * Create a <code>youtube_search_query_cache</code> table reference
     */
    public YoutubeSearchQueryCache() {
        this(DSL.name("youtube_search_query_cache"), null);
    }

    public <O extends Record> YoutubeSearchQueryCache(Table<O> child, ForeignKey<O, YoutubeSearchQueryCacheRecord> key) {
        super(child, key, YOUTUBE_SEARCH_QUERY_CACHE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<YoutubeSearchQueryCacheRecord, Integer> getIdentity() {
        return (Identity<YoutubeSearchQueryCacheRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<YoutubeSearchQueryCacheRecord> getPrimaryKey() {
        return Keys.YOUTUBE_SEARCH_QUERY_CACHE_PKEY;
    }

    @Override
    public YoutubeSearchQueryCache as(String alias) {
        return new YoutubeSearchQueryCache(DSL.name(alias), this);
    }

    @Override
    public YoutubeSearchQueryCache as(Name alias) {
        return new YoutubeSearchQueryCache(alias, this);
    }

    @Override
    public YoutubeSearchQueryCache as(Table<?> alias) {
        return new YoutubeSearchQueryCache(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public YoutubeSearchQueryCache rename(String name) {
        return new YoutubeSearchQueryCache(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public YoutubeSearchQueryCache rename(Name name) {
        return new YoutubeSearchQueryCache(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public YoutubeSearchQueryCache rename(Table<?> name) {
        return new YoutubeSearchQueryCache(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, LocalDateTime> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Integer, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Integer, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}