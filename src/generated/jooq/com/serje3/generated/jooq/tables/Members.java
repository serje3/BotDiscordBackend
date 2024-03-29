/*
 * This file is generated by jOOQ.
 */
package com.serje3.generated.jooq.tables;


import com.serje3.generated.jooq.DefaultSchema;
import com.serje3.generated.jooq.Keys;
import com.serje3.generated.jooq.tables.records.MembersRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
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
public class Members extends TableImpl<MembersRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>members</code>
     */
    public static final Members MEMBERS = new Members();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MembersRecord> getRecordType() {
        return MembersRecord.class;
    }

    /**
     * The column <code>members.id</code>.
     */
    public final TableField<MembersRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>members.user_id</code>.
     */
    public final TableField<MembersRecord, Long> USER_ID = createField(DSL.name("user_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>members.guild_id</code>.
     */
    public final TableField<MembersRecord, Long> GUILD_ID = createField(DSL.name("guild_id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>members.effective_username</code>.
     */
    public final TableField<MembersRecord, String> EFFECTIVE_USERNAME = createField(DSL.name("effective_username"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>members.is_admin</code>.
     */
    public final TableField<MembersRecord, Boolean> IS_ADMIN = createField(DSL.name("is_admin"), SQLDataType.BOOLEAN.defaultValue(DSL.field(DSL.raw("false"), SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>members.join_date</code>.
     */
    public final TableField<MembersRecord, LocalDateTime> JOIN_DATE = createField(DSL.name("join_date"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    private Members(Name alias, Table<MembersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Members(Name alias, Table<MembersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>members</code> table reference
     */
    public Members(String alias) {
        this(DSL.name(alias), MEMBERS);
    }

    /**
     * Create an aliased <code>members</code> table reference
     */
    public Members(Name alias) {
        this(alias, MEMBERS);
    }

    /**
     * Create a <code>members</code> table reference
     */
    public Members() {
        this(DSL.name("members"), null);
    }

    public <O extends Record> Members(Table<O> child, ForeignKey<O, MembersRecord> key) {
        super(child, key, MEMBERS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<MembersRecord, Integer> getIdentity() {
        return (Identity<MembersRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<MembersRecord> getPrimaryKey() {
        return Keys.MEMBERS_PKEY;
    }

    @Override
    public List<UniqueKey<MembersRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.UNIQUE_USER_GUILD_PAIR);
    }

    @Override
    public Members as(String alias) {
        return new Members(DSL.name(alias), this);
    }

    @Override
    public Members as(Name alias) {
        return new Members(alias, this);
    }

    @Override
    public Members as(Table<?> alias) {
        return new Members(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Members rename(String name) {
        return new Members(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Members rename(Name name) {
        return new Members(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Members rename(Table<?> name) {
        return new Members(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Long, Long, String, Boolean, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super Integer, ? super Long, ? super Long, ? super String, ? super Boolean, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super Integer, ? super Long, ? super Long, ? super String, ? super Boolean, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
