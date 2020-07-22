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

    //通过企业ID查询所有的人以及已经上传的图片
    Result<?> queryFaceImageByCid(FaceUserImage faceImage);

}
