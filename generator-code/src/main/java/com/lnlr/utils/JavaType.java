package com.lnlr.utils;

/**
 * @author 雷洪飞 on 15:09 2018/1/10.
 * desc java类型和数据库类型转换
 */
public enum JavaType {
    STRING("String"),
    CHAR("String"),
    VARCHAR("String"),
    VARCHAR2("String"),
    LONGVARCHAR("String"),
    TEXT("String"),
    MEDIUMTEXT("String"),
    LONGTEXT("String"),
    NUMERIC("BigDecimal"),
    DECIMAL("BigDecimal"),
    BIT("Boolean"),
    TINYINT("Integer"),
    SMALLINT("Short"),
    INTEGER("Integer"),
    BIGINT("Long"),
    NUMBER("Long"),
    REAL("Float"),
    FLOAT("Double"),
    DOUBLE("Double"),
    BINARY("byte[]"),
    VARBINARY("byte[]"),
    LONGVARBINARY("byte[]"),
    BLOB("byte[]"),
    CLOB("String"),
    DATE("Date"),
    DATETIME("LocalDateTime"),
    TIME("LocalDateTime"),
    TIMESTAMP("LocalDateTime"),
    INT("Integer");

    private String typeName;

    private JavaType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public static String getJavaType(String sqlType) {
        JavaType javaType = null;
        if (sqlType != null && !"".equals(sqlType)) {
            javaType = valueOf(sqlType.replaceAll("\\(\\d{1,9}\\)$", "").toUpperCase());
            return javaType == null ? STRING.getTypeName() : javaType.getTypeName();
        } else {
            return STRING.getTypeName();
        }
    }

    public static void main(String[] args) {
        System.out.println("STRING:" + getJavaType("STRING"));
        System.out.println("CHAR:" + getJavaType("CHAR"));
        System.out.println("DATE:" + getJavaType("DATE"));
    }

}
