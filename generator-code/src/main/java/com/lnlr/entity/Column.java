package com.lnlr.entity;

/**
 * @author 雷洪飞 on 9:40 2018/1/10.
 * 列数据
 */
public class Column {
    /**
     *  列名
     */
    private String name;

    /**
     *  列类型
     */
    private String type;

    /**
     *  列大小
     */
    private int size;

    /**
     *  是否为空
     */
    private boolean nullable;

    /**
     *  默认值
     */
    private String defaultValue;

    /**
     * 数值
     */
    private int digits;

    /**
     * 列注释
     */
    private String comment;

    /**
     * java类型
     */
    private String javaType;

    /**
     * 列名称
     */
    private String fieldName;

    /**
     * set方法
     */
    private String setMethod;

    /**
     * get方法
     */
    private String getMethod;

    /**
     * 对应表
     */
    private Table table;

    public Column(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getDigits() {
        return digits;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getSetMethod() {
        return setMethod;
    }

    public void setSetMethod(String setMethod) {
        this.setMethod = setMethod;
    }

    public String getGetMethod() {
        return getMethod;
    }

    public void setGetMethod(String getMethod) {
        this.getMethod = getMethod;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
