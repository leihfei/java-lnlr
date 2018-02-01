package com.lnlr.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by azl on 2017/3/9.
 * 雷洪飞 操作文件工具类
 * @author 雷洪飞
 */
public class FileUtils {

    public static final long ONE_KB = 1024L;
    public static final long ONE_MB = 1048576L;
    public static final long ONE_GB = 1073741824L;
    public static final long ONE_TB = 1099511627776L;
    public static final long ONE_PB = 1125899906842624L;
    private static Logger log = Logger.getLogger("FileUtils");

    public FileUtils() {
    }

    public static String getHumanReadableFileSize(long fileSize) {
        if (fileSize < 0L) {
            return String.valueOf(fileSize);
        } else {
            String result = getHumanReadableFileSize(fileSize, 1125899906842624L, "PB");
            if (result != null) {
                return result;
            } else {
                result = getHumanReadableFileSize(fileSize, 1099511627776L, "TB");
                if (result != null) {
                    return result;
                } else {
                    result = getHumanReadableFileSize(fileSize, 1073741824L, "GB");
                    if (result != null) {
                        return result;
                    } else {
                        result = getHumanReadableFileSize(fileSize, 1048576L, "MB");
                        if (result != null) {
                            return result;
                        } else {
                            result = getHumanReadableFileSize(fileSize, 1024L, "KB");
                            return result != null ? result : String.valueOf(fileSize) + "B";
                        }
                    }
                }
            }
        }
    }

    private static String getHumanReadableFileSize(long fileSize, long unit, String unitName) {
        if (fileSize == 0L) {
            return "0";
        } else if (fileSize / unit >= 1L) {
            double value = (double) fileSize / (double) unit;
            DecimalFormat df = new DecimalFormat("######.##" + unitName);
            return df.format(value);
        } else {
            return null;
        }
    }

    /**
     * 根据文件获取文件后缀名
     *
     * @param fileName 文件名
     * @return 后缀名
     */
    public static String getFileExt(String fileName) {
        if (fileName == null) {
            return "";
        } else {
            String ext = "";
            int lastIndex = fileName.lastIndexOf(".");
            if (lastIndex >= 0) {
                ext = fileName.substring(lastIndex + 1).toLowerCase();
            }
            return ext;
        }
    }

    /**
     * 获取文件名
     *
     * @param name 文件元原始名称
     * @return String
     */
    public static String getRealName(String name) {
        if (name == null) {
            return "";
        } else {
            int endIndex = name.lastIndexOf(".");
            return endIndex == -1 ? null : name.substring(0, endIndex);
        }
    }


    /**
     * 得到uuid生成后的名称
     *
     * @param file 文件
     * @return 新的uuid组成的名称
     */
    public static String getUuidName(MultipartFile file, String uuid) {
        //得到文件的后缀名
        String fileExt = getFileExt(file.getOriginalFilename());
        //生成新的uuid文件名
        return uuid + "." + fileExt;
    }

    public static String getUUid() {
        //得到uuid名称
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    /**
     * 根据时间得到当年，当天，当日的文件
     *
     * @return String
     */
    public static String getUploadFileDirNameByDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sd = dateFormat.format(new Date());
        //将字符串分割
        String[] split = sd.split("-");
        //得到的肯定是三个数组
        String newFileDir = File.separator + split[0] + File.separator + split[1] + File.separator + split[2];
        return newFileDir;
    }

    /**
     * 根据request，根目录文件名，当前年月名得到文件名
     *
     * @param rootFileDir 根目录名称
     * @return String
     */
    public static String getUploadFileDirByDate(String rootFileDir) {
        //生成文件的路径
        StringBuffer uploadFileDir = new StringBuffer(rootFileDir);
        uploadFileDir.append(getUploadFileDirNameByDate());
        return uploadFileDir.toString();
    }


    /**
     * 将文件写入磁盘，并返回uuid
     *
     * @param request 请求request
     * @param sonDir  子目录
     * @param file    文件
     * @return 保存后的文件地址
     */
    public static String writeFiles(HttpServletRequest request, String sonDir, MultipartFile file) {
        // 在服务器保存到以下目录/app/pattms
        String root = File.separator + "app" + File.separator + "pttms";
        //文件名
        String uUid = FileUtils.getUUid();
        String sondirName = File.separator + "upload" + File.separator + sonDir + File.separator + getUuidName(file, uUid);
        String uploadDir = root  + sondirName;
        File upload = new File(uploadDir);
        writeFile(file, upload);
        return uploadDir;
    }


    /**
     * 将文件写入磁盘，并返回uuid
     *
     * @param fileRoot 文件根目录地址
     * @param request  请求request
     * @param sonDir   子目录
     * @param file     文件
     * @return 保存后的文件地址
     */
    public static String writeFiles(String fileRoot, HttpServletRequest request, String sonDir, MultipartFile file) {
        //文件名
        String uUid = FileUtils.getUUid();
        String sondirName = File.separator + "upload" + File.separator + sonDir + File.separator + getUuidName(file, uUid);
        String uploadDir = fileRoot + sondirName;
        File upload = new File(uploadDir);
        writeFile(file, upload);
        return uploadDir;
    }

    /**
     * 真实写文件
     *
     * @param file
     * @param upload
     */
    private static void writeFile(MultipartFile file, File upload) {
        try {
            org.apache.commons.io.FileUtils.writeByteArrayToFile(upload, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            if (upload.exists()) {
                upload.delete();
            }
        }
    }

}
