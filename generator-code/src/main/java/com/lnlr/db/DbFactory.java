package com.lnlr.db;

import com.lnlr.entity.ModelObj;

/**
 * @author 雷洪飞 on 9:31 2018/1/10.
 * 创建数据库连接
 */
public class DbFactory {

    /**
     * oracle驱动
     */
    private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";

    /**
     * mysql驱动
     */
    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 根据配置文件中给定的数据库类型，生成数据库资源返回
     * 返回一个数据库资源
     *
     * @return
     */
    public static DbRescource getDbResource() throws Exception {
        DbRescource db = null;
        String dialect = ModelObj.getInstance().getJdbcDriver();
        if (dialect != null || !"".equals(dialect)) {
            // 比较是oracle,mysql
            if (ORACLE_DRIVER.equals(ModelObj.getInstance().getJdbcDriver())) {
                // 创建oracle数据库资源返回
                db = new Oracle();
            } else if (MYSQL_DRIVER.equals(ModelObj.getInstance().getJdbcDriver())) {
                // 创建mysql数据库返回
                db = new Mysql();
            }
        } else {
            throw new Exception(DbFactory.class.getName() + ":>>>请指定数据库dialect......");
        }
        return db;
    }
}
