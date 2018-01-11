package com.lnlr.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * @author 雷洪飞 on 13:11 2018/1/10.
 * 文件操作工具
 */
public class FileUtils {
    protected static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public FileUtils() {
    }

    public static void writeFile(String content, String filePath) {
        try {
            if (createFile(filePath)) {
                FileWriter fileWriter = new FileWriter(filePath, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(content);
                bufferedWriter.close();
                fileWriter.close();
            } else {
                logger.info("生成失败，文件已存在！");
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static boolean createFile(String descFileName) {
        File file = new File(descFileName);
        if (file.exists()) {
            logger.debug("文件 " + descFileName + " 已存在!");
            return false;
        } else if (descFileName.endsWith(File.separator)) {
            logger.debug(descFileName + " 为目录，不能创建目录!");
            return false;
        } else if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            logger.debug("创建文件所在的目录失败!");
            return false;
        } else {
            try {
                if (file.createNewFile()) {
                    logger.debug(descFileName + " 文件创建成功!");
                    return true;
                } else {
                    logger.debug(descFileName + " 文件创建失败!");
                    return false;
                }
            } catch (Exception var3) {
                var3.printStackTrace();
                logger.debug(descFileName + " 文件创建失败!");
                return false;
            }
        }
    }
}
