package com.lnlr.generator;

import com.lnlr.entity.Table;

import java.util.List;

/**
 * @author 雷洪飞 on 12:50 2018/1/10.
 * 代码生成接口
 */
public interface Generator {

    /**
     * 根据表生成数据
     * @param table
     * @throws Exception
     */
    void generator(Table table) throws Exception;

    /**
     * 根据表集合生成数据
     * @param tables
     * @throws Exception
     */
    void generator(List<Table> tables) throws Exception;
}
