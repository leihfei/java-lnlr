package com.lnlr.db;

import com.lnlr.entity.ModelObj;
import com.lnlr.entity.Table;
import com.lnlr.utils.ColumnUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author 雷洪飞 on 9:23 2018/1/10.
 * 获取到oracle数据库资源
 */
public class Oracle extends DbRescource {

    public Oracle() {
        Properties props = new Properties();
        props.put("remarksReporting", "true");
        props.put("user", ModelObj.getInstance().getJdbcUserName());
        props.put("password", ModelObj.getInstance().getJdbcPassword());

        try {
            Class.forName(ModelObj.getInstance().getJdbcDriver()).newInstance();
            this.conn = DriverManager.getConnection(ModelObj.getInstance().getJdbcUrl(), props);
        } catch (ClassNotFoundException var3) {
            var3.printStackTrace();
        } catch (SQLException var4) {
            var4.printStackTrace();
        } catch (InstantiationException var5) {
            var5.printStackTrace();
        } catch (IllegalAccessException var6) {
            var6.printStackTrace();
        }

    }

    @Override
    public Table getTable(String tableName) throws SQLException {
        this.connectionTest(this.conn);
        Table t = new Table(tableName);
        ResultSet rs = null;
        t.setColumns(new ArrayList());
        try {
            DatabaseMetaData dmd = this.conn.getMetaData();
            rs = dmd.getColumns((String) null, ModelObj.getInstance().getJdbcUserName().toUpperCase(), tableName, (String) null);
            ColumnUtils.setColumns(rs, t);
            rs = dmd.getPrimaryKeys((String) null, (String) null, tableName);
            t.setPk(ColumnUtils.getPk(rs));
        } catch (SQLException var8) {
            throw var8;
        } finally {
            this.close(this.conn, (PreparedStatement) null, rs);
        }
        return t;
    }

    @Override
    public List<Table> getTables() throws SQLException {
        return null;
    }
}
