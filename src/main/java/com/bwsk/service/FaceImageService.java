package com.bwsk.service;

import com.bwsk.entity.FaceUserImage;
import com.bwsk.entity.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * 人脸接口
 */
public interface FaceImageService {

    // 人脸图片上传
    Result<?> imageUpload(MultipartFile file, FaceUserImage faceImage, int number);

    //删除人脸图片
    Result<?> deleteFaceImage(FaceUserImage faceImage);
}
