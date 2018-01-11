package com.lnlr.utils;

import java.io.File;
import java.util.regex.Matcher;

/**
 * @author 雷洪飞 on 13:11 2018/1/10.
 * 描述需要生成哪种类型文件
 */
public class FileType {

    /**
     * 文件类型：
     * service，dao，java，pom
     */
    private String fileType;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 模板名称
     */
    private String templeName;

    /**
     * 后缀名称
     */
    private String prefxxName;

    public FileType(String fileType, String templeName) {
        this.fileType = fileType;
        this.templeName = templeName;
    }

    public FileType(String fileType, String packageName, String templeName, String prefxxName) {
        this.fileType = fileType;
        this.packageName = packageName;
        this.templeName = templeName;
        this.prefxxName = prefxxName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTempleName() {
        return templeName;
    }

    public void setTempleName(String templeName) {
        this.templeName = templeName;
    }

    public String getPrefxxName() {
        return prefxxName;
    }

    public void setPrefxxName(String prefxxName) {
        this.prefxxName = prefxxName;
    }

    public String getJavaStorePath() {
        String packageDecl = null;
        if (packageName != null && !"".equals(packageName)) {
            packageDecl = packageName;
        }
        packageDecl = packageDecl.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
        return packageDecl;
    }
}
