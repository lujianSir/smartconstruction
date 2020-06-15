package com.bwsk.service.impl;

import com.bwsk.entity.FileInfo;
import com.bwsk.entity.Result;
import com.bwsk.mapper.FileMapper;
import com.bwsk.service.FileService;
import com.bwsk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public String fileUpload(MultipartFile file, int kind) {
        // TODO Auto-generated method stub
        if (!file.isEmpty()) {
            try {
                // 文件1存放服务端的位置
                File dir = null;
                long now = System.currentTimeMillis();
                String filesuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String filename = now + filesuffix;
                String newrootPath = System.getProperty("user.dir") + "/upload";
                System.out.println(newrootPath);
                // 0代表图片 1代表视频
                switch (kind) {
                    case 0:
                        dir = new File(newrootPath + File.separator + "picture" + File.separator);
                        break;
                    case 1:
                        dir = new File(newrootPath + File.separator + "video" + File.separator);
                        break;
                    default:
                        break;
                }
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                String filePath = dir.getAbsolutePath() + File.separator + filename;

                // 写文件到服务器
                File serverFile = new File(filePath);
                file.transferTo(serverFile);

                // 录入文件信息
                FileInfo fileinfo = new FileInfo();
                fileinfo.setFname(filename);
                fileinfo.setFrealurl(filePath);
                String fvirtualurl = "";
                if (kind == 1) {// 视频
                    fvirtualurl = "/image/video/" + filename;
                } else {
                    fvirtualurl = "/image/picture/" + filename;
                }
                fileinfo.setFvirtualurl(fvirtualurl);
                fileinfo.setFuploadtime(Utils.getCurrent());
                fileMapper.insertFileInfo(fileinfo);
                return fvirtualurl;
            } catch (Exception e) {
                return "服务端错误";
            }
        } else {
            return "请上传文件";
        }
    }

    @Override
    public Result<?> fileinfoDelete(String fvirtualurl) {
        // TODO Auto-generated method stub
        try {
            FileInfo fileinfo = new FileInfo();
            // 根据名称查询数据,获取文件路径
            fileinfo = fileMapper.queryFileInfoByName(fvirtualurl);
            // 删除文件
            File file = new File(fileinfo.getFrealurl());
            if (file.exists()) {
                file.delete();
            }
            // 删除记录
            fileMapper.deleteFileInfoById(fileinfo.getFid());
            return Result.success();
        } catch (Exception e) {
            return Result.error(500, "服务端错误");
        }
    }

}
