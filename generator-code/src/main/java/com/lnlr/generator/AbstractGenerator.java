package com.lnlr.generator;

import com.lnlr.entity.Table;
import freemarker.template.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;

/**
 * @author 雷洪飞 on 12:53 2018/1/10.
 * 定义一个抽象类表示数据
 */
public abstract class AbstractGenerator {
    protected static Logger logger = LoggerFactory.getLogger(AbstractGenerator.class);


    /**
     * 模板对象配置
     */
    protected Configuration cfg;

    /**
     * 定义一个表名
     */
    protected String tableName;

    /**
     * 定义一个表
     */
    protected Table table;

    /**
     * 模板文件位置
     */
    protected String templatePath;

    /**
     * 分隔符，window:\\   linux：/
     */
    protected String separator = File.separator;


    /**
     * java代码生成位置
     */
    protected String javaPath;

    /**
     * java资源文件路径
     */
    protected String javaResourcesPath;

    /**
     * jsp生成位置
     */
    protected String viewPath;

    /**
     * js生成位置
     */
    protected String jsPath;

    /**
     * webapp目录
     */
    protected String webappPath;

    /**
     * 项目文件
     */
    protected File projectFile;

    /**
     * 项目名称
     */
    protected String projectName;

    /**
     * 项目路径
     */
    protected String projectPath;

    /**
     * 存放模板数据
     */
    protected Map<String, Object> model;
}
