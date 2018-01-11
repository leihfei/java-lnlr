package com.lnlr.utils;

import com.lnlr.entity.Column;
import com.lnlr.entity.ModelObj;
import com.lnlr.entity.Table;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;

/**
 * @author 雷洪飞 on 15:18 2018/1/10.
 * 列数据类型转换
 */
public class ConvertHandler {
    public ConvertHandler() {
    }

    /**
     * @param table
     * @throws Exception
     */
    public static void tableHandle(Table table) throws Exception {
        if (table != null && table.getTableName() != null && !"".equals(table.getTableName())) {
            if (table.getColumns() != null && table.getColumns().size() != 0) {
                String clazzName = ModelObj.getInstance().getClassName();
                if (StringUtils.isBlank(clazzName)) {
                    clazzName = table2clazzName(table.getTableName());
                }
                table.setClassName(clazzName);
                Iterator i$ = table.getColumns().iterator();

                Column col;
                do {
                    if (!i$.hasNext()) {
//                        cleanColumn(table);
                        return;
                    }
                    col = (Column) i$.next();
                    columnHandler(col);
                } while (col.getFieldName() != null);

                throw new Exception(ConvertHandler.class.getName() + ": 转换column为field时出错,column:[" + col.getName() + "].");
            } else {
                throw new Exception(ConvertHandler.class.getName() + ":  表：[ " + table.getTableName() + " ] ,不包含任何列信息...");
            }
        } else {
            throw new Exception(ConvertHandler.class.getName() + ": 参数  Table 不能为null.");
        }
    }

    /**
     * 设置列属性
     * @param column
     */
    public static void columnHandler(Column column) {
        if (column != null) {
            column.setJavaType(JavaType.getJavaType(column.getType()));
            column.setFieldName(column2field(column.getName()));
            String filedName = column.getFieldName();
            String methodName = filedName.substring(0, 1).toUpperCase() + filedName.substring(1, filedName.length());
            column.setSetMethod("set" + methodName);
            if (column.getJavaType().equalsIgnoreCase("boolean")) {
                column.setGetMethod("is" + methodName);
            } else {
                column.setGetMethod("get" + methodName);
            }

        }
    }

    private static void cleanColumn(Table table) {
        if (table.getPk() != null && table.getColumns() != null) {
            Iterator i$ = table.getColumns().iterator();

            while (i$.hasNext()) {
                Column col = (Column) i$.next();
                if (col.getName().equalsIgnoreCase(table.getPk().getName())) {
                    table.setPk(col);
                }
            }
            //table.getColumns().remove(table.getPk());
        }

    }

    public static String table2clazzName(String str) {
        if (str != null && !"".equals(str)) {
            String[] arrs = str.split("_");
            StringBuilder sb = new StringBuilder();
            String[] arr$ = arrs;
            int len$ = arrs.length;

            for (int i$ = 0; i$ < len$; ++i$) {
                String s = arr$[i$];
                sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1).toLowerCase());
            }

            return sb.toString();
        } else {
            return null;
        }
    }

    public static String column2field(String str) {
        if (str != null && !"".equals(str)) {
            str = str.toLowerCase();
            String[] arrs = str.split("_");
            if (arrs != null && arrs.length != 0) {
                StringBuilder sb = new StringBuilder();
                int len = arrs.length;
                sb.append(arrs[0]);
                if (len > 1) {
                    for (int i = 1; i < len; ++i) {
                        String s = arrs[i];
                        sb.append(Character.toUpperCase(s.charAt(0)));
                        sb.append(s.substring(1));
                    }
                }

                return sb.toString();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String getEntityInstance(String entityName) {
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(entityName.charAt(0))).append(entityName.substring(1));
        return sb.toString();
    }
}
