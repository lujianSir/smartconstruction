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
}
