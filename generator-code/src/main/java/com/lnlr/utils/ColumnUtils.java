package com.lnlr.utils;

import com.lnlr.entity.Column;
import com.lnlr.entity.Table;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 雷洪飞 on 12:45 2018/1/10.
 * desc
 */
public class ColumnUtils {

    /**
     * 把所有的列数据保存到table中
     * @param rs
     * @param table
     * @throws SQLException
     */
    public static void setColumns(ResultSet rs, Table table) throws SQLException {
        while (rs.next()) {
            Column col = new Column();
            col.setName(rs.getString("COLUMN_NAME"));
            col.setType(rs.getString("TYPE_NAME"));
            col.setSize(rs.getInt("COLUMN_SIZE"));
            col.setNullable(rs.getBoolean("NULLABLE"));
            col.setDigits(rs.getInt("DECIMAL_DIGITS"));
            col.setDefaultValue(rs.getString("COLUMN_DEF"));
            col.setComment(rs.getString("REMARKS"));
            table.getColumns().add(col);
        }
    }

    /**
     * 返回主键信息
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Column getPk(ResultSet rs) throws SQLException {
        Column pk = new Column();
        while (rs.next()) {
            pk.setName(rs.getString("COLUMN_NAME"));
        }
        return pk;
    }
}
