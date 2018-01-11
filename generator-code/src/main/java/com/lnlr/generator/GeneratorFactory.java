package com.lnlr.generator;

import com.lnlr.db.DbFactory;
import com.lnlr.db.DbRescource;
import com.lnlr.entity.ModelObj;
import com.lnlr.entity.Table;
import com.lnlr.utils.ConvertHandler;
import com.lnlr.utils.FileType;
import com.lnlr.utils.Resources;

/**
 * @author 雷洪飞 on 12:55 2018/1/10.
 * 利用工厂来生成代码
 */
public class GeneratorFactory {

    /**
     * 表
     */
    private Table table;

    /**
     * 表名
     */
    private String tableName;


    public GeneratorFactory() {
        new Resources();
        // 默认赋值
        this.tableName = ModelObj.getInstance().getTableName();
        // 初始化数据
        this.init();
    }

    public GeneratorFactory(Table table) {
        this.table = table;
    }

    public GeneratorFactory(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 生成java文件
     */
    public void genJaveTemplate() throws Exception {

        // 调用模板，生成文件,实体类
        new GeneratorCode(new FileType("Entity", ModelObj.getInstance().getEntityPackage(), "Entity.ftl", ".java"),
                Resources.COMMON_DIR).generator(table);

//         生成dao
        new GeneratorCode(new FileType("DAO", ModelObj.getInstance().getDaoPackage(), "Dao.ftl", "DAO.java"),
                Resources.COMMON_DIR).generator(table);

        // 实现service
        new GeneratorCode(new FileType("Service", ModelObj.getInstance().getServicePackage(), "Service.ftl", "Service.java"),
                Resources.FUNCTIONAL_DIR, "_service").generator(table);

        // 实现serviceImpl
        new GeneratorCode(new FileType("ServiceImpl", ModelObj.getInstance().getServiceImplPackage(), "ServiceImpl.ftl", "ServiceImpl.java"),
                Resources.FUNCTIONAL_DIR, "_service").generator(table);


        // 实现controller
        new GeneratorCode(new FileType("Controller", ModelObj.getInstance().getControllerPackage(), "Controller.ftl", "Controller.java"),
                Resources.FUNCTIONAL_DIR, "_service").generator(table);

        // 实现application
        new GeneratorCode(new FileType("Application", "com.datababys", "Application.ftl", "Application.java"),
                Resources.FUNCTIONAL_DIR, "_service").generator(table);


        // 实现api接口
        new GeneratorCode(new FileType("ApiController", "com.datababys.api", "Api.ftl", "ApiServer.java"),
                Resources.FUNCTIONAL_DIR, "_api").generator(table);

//        // 生成pom文件
        new GeneratorCode(new FileType("api_pom", "", "apipom.ftl", "pom.xml"),
                Resources.FUNCTIONAL_DIR, "_api").generatePom();
        new GeneratorCode(new FileType("server_pom", "", "serverpom.ftl", "pom.xml"),
                Resources.FUNCTIONAL_DIR, "_service").generatePom();


    }

    /**
     * 生成js文件
     */
    public void genJsTemplate() {

    }

    /**
     * 生成angular项目文件
     */
    public void genNgTemplate() {

    }


    /**
     * 初始化数据库数据
     */
    private void init() {
        Table table = null;
        try {
            DbRescource db = DbFactory.getDbResource();
            table = db.getTable(this.tableName);
            ConvertHandler.tableHandle(table);
            System.out.println(table);
        } catch (Exception var3) {
            var3.printStackTrace();
            System.exit(-1);
        }
        this.table = table;
    }


}
