package com.bwsk.controller.app;

import com.bwsk.entity.Result;
import com.bwsk.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * 文件相关的接口
 *
 * @author lujian
 */
@Controller
@RequestMapping("/app/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/test")
    public String test() {
        return "ceshi";
    }

    /**
     * 实现文件上传
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam(value = "file", required = false) MultipartFile file, int kind) {
        return fileService.fileUpload(file, kind);
    }

    /**
     * 根据虚拟文件名称删除数据
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<?> fileinfoDelete(String fvirtualurl) {
        return fileService.fileinfoDelete(fvirtualurl);
    }

    @RequestMapping(value = "/download")
    @ResponseBody
    public Result<?> fileDownload(HttpServletResponse response, HttpServletRequest request) throws IOException {

        String path = "/mnt/html/bwsk/八维时空app.apk";
        // path是指欲下载的文件的路径。
        File file = new File(path);
        // 取得文件名。
        String filename = file.getName();
        if (!file.exists()) {
            System.out.println("Have no such file!");
            return Result.error(500, "文件不存在");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        // 设置Http响应头告诉浏览器下载这个附件,下载的文件名也是在这里设置的
        response.setHeader("Content-Disposition", "attachment;Filename=" + URLEncoder.encode(filename, "UTF-8"));
        OutputStream outputStream = response.getOutputStream();
        byte[] bytes = new byte[2048];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) > 0) {
            outputStream.write(bytes, 0, len);
        }
        fileInputStream.close();
        outputStream.close();
        System.out.println("成功");
        // JavaTool.download(s, response);
        return Result.success();
    }
}
