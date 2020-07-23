package com.bwsk.controller.app;

import com.bwsk.entity.FaceUserImage;
import com.bwsk.entity.Result;
import com.bwsk.service.FaceImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 收款相关的接口
 *
 * @author lujian
 */
@RestController
@RequestMapping("/app/face")
public class FaceImageController {

    @Autowired
    private FaceImageService faceImageService;


//    @RequestMapping("/test")
//    public String test() {
//        return "file";
//    }

    /**
     * 实现文件上传
     */
    @RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
    public Result<?> imageUpload(@RequestParam(value = "file", required = false) MultipartFile file, FaceUserImage faceImage, int number) {
        return faceImageService.imageUpload(file, faceImage, number);
    }

    /**
     * 删除人脸信息
     *
     * @param faceImage
     * @return
     */
    @RequestMapping(value = "/deleteFaceImage", method = RequestMethod.POST)
    public Result<?> deleteFaceImage(FaceUserImage faceImage) {
        return faceImageService.deleteFaceImage(faceImage);
    }

    /**
     * 通过企业ID查询所有的人以及已经上传的图片1
     *
     * @param faceImage
     * @return
     */
    @RequestMapping(value = "/queryFaceImageByCid", method = RequestMethod.POST)
    public Result<?> queryFaceImageByCid(FaceUserImage faceImage) {
        return faceImageService.queryFaceImageByCid(faceImage);
    }

}
