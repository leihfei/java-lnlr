package com.lnlr.db;

import com.lnlr.entity.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 雷洪飞 on 9:25 2018/1/10.
 * 用于生成数据库的父类型对象
 * 这样不管是oracle、mysql都可以使用这个新对象即可
 */
public abstract class DbRescource {

    protected Connection conn = null;

    /**
     * 根据表名返回表对象
     *
     * @param tableName
     * @return
     * @throws SQLException
     */
    public abstract Table getTable(String tableName) throws SQLException;

    /**
     * 返回所有的表数据对象，目前没用
     *
     * @return
     * @throws SQLException
     */
    public abstract List<Table> getTables() throws SQLException;


    public DbRescource() {
        if (this.conn == null) {
            this.conn = (new DbConnection()).getConnection();
        }
    }

    public DbRescource(Connection conn) {
        this.conn = conn;
    }

    /**
     * 测试数据库连接
     *
     * @param conn 连接
     * @throws SQLException
     */
    protected void connectionTest(Connection conn) throws SQLException {
        if (conn == null) {
            throw new SQLException(DbRescource.class.getName() + ":>>>>数据库未连接！");
        }
    }

    /**
     * 关闭资源
     *
     * @param conn
     * @param pstmt
     * @param rs
     * @throws SQLException
     */
    protected void close(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

}
