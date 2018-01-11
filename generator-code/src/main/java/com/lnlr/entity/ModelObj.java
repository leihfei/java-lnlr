package com.lnlr.entity;

/**
 * @author 雷洪飞 on 9:27 2018/1/11.
 * 将需要在模板中使用的对象封装到里面
 */
public class ModelObj {

    /**
     * jabc驱动
     */
    private String jdbcDriver;

    /**
     * jdbcurl
     */
    private String jdbcUrl;

    /**
     * username
     */
    private String jdbcUserName;

    /**
     * password
     */
    private String jdbcPassword;

    /**
     * 默认包名
     */
    private String defaultPackage;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 模块名
     */
    private String moduleName;

    /**
     * 类名
     */
    private String className;

    /**
     * 实体包
     */
    private String entityPackage;

    /**
     * dao层包
     */
    private String daoPackage;

    /**
     * service包
     */
    private String servicePackage;

    /**
     * controller包
     */
    private String controllerPackage;

    /**
     * serviceImpl包
     */
    private String serviceImplPackage;

    /**
     * 数据库catalog
     */
    private String databaseCataLog;

    /**
     * 数据库schema
     */
    private String databaseSchemaPattern;

    /**
     * 作者
     */
    private String author;

    /**
     * 表主键类型
     */
    private String tableIdType;

    /**
     * 映射文件名称，用于多个Maven中使用
     */
    private String mappingName;

    private static ModelObj instance = null;

    private ModelObj() {

    }

    public static ModelObj getInstance() {
        if (instance == null) {
            instance = new ModelObj();
        }
        return instance;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUserName() {
        return jdbcUserName;
    }

    public void setJdbcUserName(String jdbcUserName) {
        this.jdbcUserName = jdbcUserName;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public String getDefaultPackage() {
        return defaultPackage;
    }

    public void setDefaultPackage(String defaultPackage) {
        this.defaultPackage = defaultPackage;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEntityPackage() {
        return entityPackage;
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public String getControllerPackage() {
        return controllerPackage;
    }

    public void setControllerPackage(String controllerPackage) {
        this.controllerPackage = controllerPackage;
    }

    public String getServiceImplPackage() {
        return serviceImplPackage;
    }

    public void setServiceImplPackage(String serviceImplPackage) {
        this.serviceImplPackage = serviceImplPackage;
    }

    public String getDatabaseCataLog() {
        return databaseCataLog;
    }

    public void setDatabaseCataLog(String databaseCataLog) {
        this.databaseCataLog = databaseCataLog;
    }

    public String getDatabaseSchemaPattern() {
        return databaseSchemaPattern;
    }

    public void setDatabaseSchemaPattern(String databaseSchemaPattern) {
        this.databaseSchemaPattern = databaseSchemaPattern;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTableIdType() {
        return tableIdType;
    }

    public void setTableIdType(String tableIdType) {
        this.tableIdType = tableIdType;
    }

    public String getMappingName() {
        return mappingName;
    }

    public void setMappingName(String mappingName) {
        this.mappingName = mappingName;
    }
}
