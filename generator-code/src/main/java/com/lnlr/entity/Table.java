package com.lnlr.entity;

import java.util.List;

/**
 * @author 雷洪飞 on 9:40 2018/1/10.
 * 表数据
 */
public class Table {
    /**
     * 表名
     */
    private String tableName;

    /**
     * 主键
     */
    private Column pk;

    /**
     * 外键
     */
    private List<Column> fks;

    /**
     * 表类型
     */
    private String tableType;

    /**
     * 列数据
     */
    private List<Column> columns;

    /**
     * 反射对象名称
     */
    private String className;

    public Table() {
    }

    public Table(String tableName) {
        this.setTableName(tableName);
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Column getPk() {
        return pk;
    }

    public void setPk(Column pk) {
        this.pk = pk;
    }

    public List<Column> getFks() {
        return fks;
    }

    public void setFks(List<Column> fks) {
        this.fks = fks;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
