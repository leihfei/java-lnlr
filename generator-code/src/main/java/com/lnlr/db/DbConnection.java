package com.lnlr.db;

import com.lnlr.entity.ModelObj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 雷洪飞 on 9:26 2018/1/10.
 * 获取到jdbc连接
 */
public class DbConnection {
    public DbConnection() {

    }

    /**
     * 返回一个jdbc连接
     *
     * @return
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(ModelObj.getInstance().getJdbcDriver()).newInstance();
            conn = DriverManager.getConnection(ModelObj.getInstance().getJdbcUrl(), ModelObj.getInstance().getJdbcUserName(), ModelObj.getInstance().getJdbcPassword());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
