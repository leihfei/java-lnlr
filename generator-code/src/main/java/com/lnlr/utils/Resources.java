package com.lnlr.utils;

import com.lnlr.entity.ModelObj;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author 雷洪飞 on 9:27 2018/1/10.
 * desc
 */
public class Resources {
    /**
     * 配置默认包名
     */
    public static String DEFAULT_PACKAGE = "com.datababys";

    // 目录位置
    public static String FUNCTIONAL_DIR;
    public static String COMMON_DIR;
    public static String NG_DIR;

    /**
     * 加载jabc驱动信息
     */
    static {
        System.out.println("进行资源文件的初始化");
        Properties pops = new Properties();
        try {
            ClassLoader classLoader = Resources.class.getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("gennerator_template.properties");
            InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream, "UTF-8");
            pops.load(inputStreamReader);

            ModelObj modelObj = ModelObj.getInstance();
            modelObj.setJdbcDriver(pops.getProperty("jdbc.driver"));
            modelObj.setJdbcUrl(pops.getProperty("jdbc.url"));
            modelObj.setJdbcUserName(pops.getProperty("jdbc.username"));
            modelObj.setJdbcPassword(pops.getProperty("jdbc.password"));
            modelObj.setDatabaseCataLog(pops.getProperty("jdbc.mysql.schemaPattern"));
            modelObj.setDatabaseSchemaPattern(pops.getProperty("jdbc.mysql.schemaPattern"));


            modelObj.setTableName(pops.getProperty("lnlr.table.name"));
            modelObj.setModuleName(pops.getProperty("lnlr.module.name"));
            modelObj.setClassName(pops.getProperty("lnlr.class.name"));
            modelObj.setTableIdType(pops.getProperty("lnlr.table.id.type"));
            modelObj.setAuthor(pops.getProperty("lnlr.author").toString());
            modelObj.setMappingName(pops.getProperty("lnlr.mapping.name"));

            modelObj.setDefaultPackage(DEFAULT_PACKAGE);

            modelObj.setEntityPackage(DEFAULT_PACKAGE + ".dto." + modelObj.getModuleName() + ".entity");
            modelObj.setDaoPackage(DEFAULT_PACKAGE + ".dto." + modelObj.getModuleName() + ".dao");
            modelObj.setServicePackage(DEFAULT_PACKAGE + "." + modelObj.getModuleName() + ".service");
            modelObj.setServiceImplPackage(DEFAULT_PACKAGE + "." + modelObj.getModuleName() + ".service.impl");
            modelObj.setControllerPackage(DEFAULT_PACKAGE + "." + modelObj.getModuleName() + ".controller");

            // 将生成的文件目录
            FUNCTIONAL_DIR = pops.getProperty("lnlr.functional.dir");
            COMMON_DIR = pops.getProperty("lnlr.common.dir");
            NG_DIR = pops.getProperty("lnlr.ng.dir");

        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }
}
