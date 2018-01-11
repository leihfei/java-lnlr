package com.lnlr.db;

import com.lnlr.entity.Column;
import com.lnlr.entity.ModelObj;
import com.lnlr.entity.Table;
import com.lnlr.utils.ColumnUtils;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author 雷洪飞 on 9:23 2018/1/10.
 * 获取mysql数据库资源
 */
public class Mysql extends DbRescource {


    public Mysql() {
        /*
        *  在构造方法中建立数据库的连接
        */
        Properties props = new Properties();
        props.put("user", ModelObj.getInstance().getJdbcUserName());
        props.put("password", ModelObj.getInstance().getJdbcPassword());
        try {
            Class.forName(ModelObj.getInstance().getJdbcDriver()).newInstance();
            this.conn = DriverManager.getConnection(ModelObj.getInstance().getJdbcUrl(), props);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到表
     *
     * @param tableName
     * @return
     * @throws SQLException
     */
    @Override
    public Table getTable(String tableName) throws SQLException {
        /*
         *  得到了conn连接，那么就获取表数据
         *
         */
        this.connectionTest(this.conn);
        // 创建一个表
        Table table = new Table(tableName);
        ResultSet rs = null;
        // 对表的数据集设置一个集合，不然空指针
        table.setColumns(new ArrayList<Column>());
        try {
            // 获取元数据
            DatabaseMetaData metaData = this.conn.getMetaData();
            /**
             * catalog:目录名称，一般都为空.但是我这个版本的mysql必须要写上，不然没有数据
             * schema:数据库名，对于oracle来说就用户名
             * tablename:表名称
             * type :表的类型(TABLE | VIEW)注意：在使用过程中，参数名称必须使用大写的。否则得到什么东西。
             */
            rs = metaData.getColumns(ModelObj.getInstance().getDatabaseCataLog(), ModelObj.getInstance().getDatabaseSchemaPattern(), tableName, "");
            System.out.println(rs);
            // 分析数据，得到表信息，列信息
            ColumnUtils.setColumns(rs, table);
            // 得到主键信息
            rs = metaData.getPrimaryKeys(ModelObj.getInstance().getDatabaseCataLog(), ModelObj.getInstance().getDatabaseSchemaPattern(), tableName);
            // 给表设置主键
            table.setPk(ColumnUtils.getPk(rs));
        } catch (SQLException e) {
            throw e;
        } finally {
            this.close(conn, null, rs);
        }
        return table;
    }

    @Override
    public List<Table> getTables() throws SQLException {
        return null;
    }


}
