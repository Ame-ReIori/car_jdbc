package com.yygq.demo.dao.base;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yygq.demo.annotation.Table;
import com.yygq.demo.annotation.Column;
import com.yygq.demo.annotation.Pk;
import com.yygq.demo.annotation.Ignore;

import com.yygq.demo.constant.Const;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * dao base
 * @author ame
 */
@Slf4j
public class BaseDao<T, P> {
    private JdbcTemplate jdbcTemplate;
    private Class<T> clazz;

    @SuppressWarnings(value = "unchecked")
    public BaseDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * common insert
     *
     * @param t           object
     * @param ignoreNull  whether the insert operation ignores null value
     * @return success number
     */
    protected Integer insert(T t, Boolean ignoreNull){
        String table = getTableName(t);

        List<Field> filterField = getField(t, ignoreNull);

        List<String> columnList = getColumns(filterField);

        String columns = StrUtil.join(Const.SEPARATOR_COMMA, columnList);

        // construct placeholders
        String params = StrUtil.repeatAndJoin("?", columnList.size(), Const.SEPARATOR_COMMA);

        // construct values
        Object[] values = filterField.stream().map(field -> ReflectUtil.getFieldValue(t, field)).toArray();

        String sql = StrUtil.format("INSERT INTO {table} ({columns}) VALUES ({params})", Dict.create().set("table", table).set("columns", columns).set("params", params));
        log.debug("[execute sql] sql: {}", sql);
        log.debug("[execute sql] params: {}", params);
        return jdbcTemplate.update(sql, values);
    }

    /**
     * common delete
     *
     * @param pk
     * @return success number
     */
    protected Integer deleteById(P pk){
        String table = getTableName();
        String sql = StrUtil.format("DELETE FROM {table} WHERE id = ?", Dict.create().set("table", table));
        log.debug("[execute sql] sql: {}", sql);
        log.debug("[execute sql] params: {}", pk);
        return jdbcTemplate.update(sql, pk);
    }

    /**
     * common update
     *
     * @param t
     * @param pk
     * @param ignoreNull
     * @return success number
     */
    protected Integer updateById(T t, P pk, Boolean ignoreNull){
        String table = getTableName(t);

        List<Field> filterField = getField(t, ignoreNull);

        List<String> columnList = getColumns(filterField);

        List<String> columns = columnList.stream().map(s -> StrUtil.appendIfMissing(s, " = ?")).collect(Collectors.toList());
        String params = StrUtil.join(Const.SEPARATOR_COMMA, columns);

        List<Object> valueList = filterField.stream().map(field -> ReflectUtil.getFieldValue(t, field)).collect(Collectors.toList());
        valueList.add(pk);

        Object[] values = ArrayUtil.toArray(valueList, Object.class);

        String sql = StrUtil.format("UPDATE {table} SET {params} WHERE id = ?", Dict.create().set("table", table).set("params", params));
        log.debug("[execute sql] sql: {}", sql);
        log.debug("[execute sql] params: {}", params);
        return jdbcTemplate.update(sql, values);
    }

    /**
     * common query one record by id
     *
     * @param pk
     * @return one record
     */
    protected T queryOneById(P pk){
        String table = getTableName();
        String sql = StrUtil.format("SELECT * FROM {table} WHERE id = ?", Dict.create().set("table", table));
        RowMapper<T> rowMapper = new BeanPropertyRowMapper<>(clazz);
        log.debug("[execute sql] sql: {}", sql);
        log.debug("[execute sql] params: {}", pk);
        return jdbcTemplate.queryForObject(sql, new Object[]{pk}, rowMapper);
    }

    /**
     * common query some records by several attributes
     *
     * @param t
     * @return list of records
     */
    protected List<T> queryByExample(T t){
        String table = getTableName(t);
        List<Field> filterField = getField(t, true);
        List<String> columnList = getColumns(filterField);

        List<String> columns = columnList.stream().map(s -> " and " + s + " = ? ").collect(Collectors.toList());

        String where = StrUtil.join(" ", columns);

        Object[] values = filterField.stream().map(field -> ReflectUtil.getFieldValue(t, field)).toArray();

        String sql = StrUtil.format("SELECT * FROM {table} WHERE 1 = 1 {where}", Dict.create().set("table", table).set("where", StrUtil.isBlank(where) ? "" : where));
        log.debug("[execute sql] sql: {}", sql);
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, values);
        List<T> ret = CollUtil.newArrayList();
        maps.forEach(map -> ret.add(BeanUtil.fillBeanWithMap(map, ReflectUtil.newInstance(clazz), true, false)));
        return ret;
    }

    /**
     * common query all records
     *
     * @return list of records
     */
    protected List<T> queryAll(){
        String table = getTableName();

        String sql = StrUtil.format("SELECT * FROM {table} WHERE 1 = 1", Dict.create().set("table", table));

        log.debug("[execute sql] sql: {}", sql);

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        List<T> ret = CollUtil.newArrayList();

        maps.forEach(map -> ret.add(BeanUtil.fillBeanWithMap(map, ReflectUtil.newInstance(clazz), true, false)));
        return ret;
    }

    /**
     * get table name
     *
     * @param t
     * @return table's name
     */
    private String getTableName(T t){
        Table tableAnnotation = t.getClass().getAnnotation(Table.class);
        if(ObjectUtil.isNotNull(tableAnnotation)){
            return StrUtil.format("`{}`", tableAnnotation.name());
        } else {
            return StrUtil.format("`{}`", t.getClass().getName().toLowerCase());
        }
    }

    /**
     * get table name
     *
     * @return table's name
     * @warning: the github repository i learned uses it.
     *           because i am so vegetable, i don't know what i can do with it
     *           if i know, i will do something
     */
    private String getTableName(){
        Table tableAnnotation = clazz.getAnnotation(Table.class);
        if(ObjectUtil.isNotNull(tableAnnotation)){
            return StrUtil.format("`{}`", tableAnnotation.name());
        } else {
            return StrUtil.format("`{}`", clazz.getName().toLowerCase());
        }
    }

    /**
     * get attributes' value
     *
     * @param fieldList
     * @return list of attributes
     */
    private List<String> getColumns(List<Field> fieldList){
        List<String> columnList = CollUtil.newArrayList();
        for(Field field : fieldList){
            Column columnAnnotation = field.getAnnotation(Column.class);
            String columnName;
            if(ObjectUtil.isNotNull(columnAnnotation)){
                columnName = columnAnnotation.name();
            } else {
                columnName = field.getName();
            }
            columnList.add(StrUtil.format("`{}`", columnName));
        }
        return columnList;
    }

    /**
     * get field name
     *
     * @param t           object
     * @param ignoreNull  whether the insert operation ignores null value
     * @return list of field
     */
    private List<Field> getField(T t, Boolean ignoreNull){
        // get all fields
        Field[] fields = ReflectUtil.getFields(t.getClass());

        // filter fields not exist and auto-increase fields
        List<Field> filterField;
        Stream<Field> fieldStream = CollUtil.toList(fields).stream().filter(field ->
                ObjectUtil.isNull(field.getAnnotation(Ignore.class)) || ObjectUtil.isNull(field.getAnnotation(Pk.class))
        );

        if(ignoreNull) {
            filterField = fieldStream.filter(field -> ObjectUtil.isNotNull(ReflectUtil.getFieldValue(t, field))).collect(Collectors.toList());
        } else {
            filterField = fieldStream.collect(Collectors.toList());
        }
        return filterField;
    }
}
