package com.lnlr.demo.controller;

import com.lnlr.demo.utils.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 雷洪飞 on 14:16 2018/2/1.
 * desc
 */
@Controller
public class DemoController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    /**
     * 文件上传到本地磁盘，然后使用浏览器直接访问
     * @param multipartFile
     * @param request
     * @return
     */
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("multipartFile") MultipartFile multipartFile, HttpServletRequest request) {
        String s = FileUtils.writeFiles("D://temp_files", request, "test", multipartFile);
        System.out.println("文件路径" + s);
        return s;
    }

}
