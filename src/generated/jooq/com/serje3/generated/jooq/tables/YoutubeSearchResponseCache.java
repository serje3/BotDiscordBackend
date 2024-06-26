/*
 * This file is generated by jOOQ.
 */
package com.serje3.generated.jooq.tables;


import com.serje3.generated.jooq.DefaultSchema;
import com.serje3.generated.jooq.Keys;
import com.serje3.generated.jooq.tables.records.YoutubeSearchResponseCacheRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function9;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row9;
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
public class YoutubeSearchResponseCache extends TableImpl<YoutubeSearchResponseCacheRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>youtube_search_response_cache</code>
     */
    public static final YoutubeSearchResponseCache YOUTUBE_SEARCH_RESPONSE_CACHE = new YoutubeSearchResponseCache();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<YoutubeSearchResponseCacheRecord> getRecordType() {
        return YoutubeSearchResponseCacheRecord.class;
    }

    /**
     * The column <code>youtube_search_response_cache.id</code>.
     */
    public final TableField<YoutubeSearchResponseCacheRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>youtube_search_response_cache.query_id</code>.
     */
    public final TableField<YoutubeSearchResponseCacheRecord, Integer> QUERY_ID = createField(DSL.name("query_id"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>youtube_search_response_cache.etag</code>.
     */
    public final TableField<YoutubeSearchResponseCacheRecord, String> ETAG = createField(DSL.name("etag"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>youtube_search_response_cache.video_id</code>.
     */
    public final TableField<YoutubeSearchResponseCacheRecord, String> VIDEO_ID = createField(DSL.name("video_id"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>youtube_search_response_cache.title</code>.
     */
    public final TableField<YoutubeSearchResponseCacheRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(150), this, "");

    /**
     * The column <code>youtube_search_response_cache.channel_title</code>.
     */
    public final TableField<YoutubeSearchResponseCacheRecord, String> CHANNEL_TITLE = createField(DSL.name("channel_title"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>youtube_search_response_cache.channel_id</code>.
     */
    public final TableField<YoutubeSearchResponseCacheRecord, String> CHANNEL_ID = createField(DSL.name("channel_id"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>youtube_search_response_cache.publish_time</code>.
     */
    public final TableField<YoutubeSearchResponseCacheRecord, LocalDateTime> PUBLISH_TIME = createField(DSL.name("publish_time"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>youtube_search_response_cache.thumbnail_url</code>.
     */
    public final TableField<YoutubeSearchResponseCacheRecord, String> THUMBNAIL_URL = createField(DSL.name("thumbnail_url"), SQLDataType.VARCHAR(255), this, "");

    private YoutubeSearchResponseCache(Name alias, Table<YoutubeSearchResponseCacheRecord> aliased) {
        this(alias, aliased, null);
    }

    private YoutubeSearchResponseCache(Name alias, Table<YoutubeSearchResponseCacheRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>youtube_search_response_cache</code> table
     * reference
     */
    public YoutubeSearchResponseCache(String alias) {
        this(DSL.name(alias), YOUTUBE_SEARCH_RESPONSE_CACHE);
    }

    /**
     * Create an aliased <code>youtube_search_response_cache</code> table
     * reference
     */
    public YoutubeSearchResponseCache(Name alias) {
        this(alias, YOUTUBE_SEARCH_RESPONSE_CACHE);
    }

    /**
     * Create a <code>youtube_search_response_cache</code> table reference
     */
    public YoutubeSearchResponseCache() {
        this(DSL.name("youtube_search_response_cache"), null);
    }

    public <O extends Record> YoutubeSearchResponseCache(Table<O> child, ForeignKey<O, YoutubeSearchResponseCacheRecord> key) {
        super(child, key, YOUTUBE_SEARCH_RESPONSE_CACHE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<YoutubeSearchResponseCacheRecord, Integer> getIdentity() {
        return (Identity<YoutubeSearchResponseCacheRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<YoutubeSearchResponseCacheRecord> getPrimaryKey() {
        return Keys.YOUTUBE_SEARCH_RESPONSE_CACHE_PKEY;
    }

    @Override
    public List<ForeignKey<YoutubeSearchResponseCacheRecord, ?>> getReferences() {
        return Arrays.asList(Keys.YOUTUBE_SEARCH_RESPONSE_CACHE__YOUTUBE_SEARCH_RESPONSE_CACHE_QUERY_ID_FKEY);
    }

    private transient YoutubeSearchQueryCache _youtubeSearchQueryCache;

    /**
     * Get the implicit join path to the
     * <code>public.youtube_search_query_cache</code> table.
     */
    public YoutubeSearchQueryCache youtubeSearchQueryCache() {
        if (_youtubeSearchQueryCache == null)
            _youtubeSearchQueryCache = new YoutubeSearchQueryCache(this, Keys.YOUTUBE_SEARCH_RESPONSE_CACHE__YOUTUBE_SEARCH_RESPONSE_CACHE_QUERY_ID_FKEY);

        return _youtubeSearchQueryCache;
    }

    @Override
    public YoutubeSearchResponseCache as(String alias) {
        return new YoutubeSearchResponseCache(DSL.name(alias), this);
    }

    @Override
    public YoutubeSearchResponseCache as(Name alias) {
        return new YoutubeSearchResponseCache(alias, this);
    }

    @Override
    public YoutubeSearchResponseCache as(Table<?> alias) {
        return new YoutubeSearchResponseCache(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public YoutubeSearchResponseCache rename(String name) {
        return new YoutubeSearchResponseCache(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public YoutubeSearchResponseCache rename(Name name) {
        return new YoutubeSearchResponseCache(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public YoutubeSearchResponseCache rename(Table<?> name) {
        return new YoutubeSearchResponseCache(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, Integer, String, String, String, String, String, LocalDateTime, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function9<? super Integer, ? super Integer, ? super String, ? super String, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function9<? super Integer, ? super Integer, ? super String, ? super String, ? super String, ? super String, ? super String, ? super LocalDateTime, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
