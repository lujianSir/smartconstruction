package com.bwsk.mapper;

import com.bwsk.entity.FaceUserImage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaceImageMapper {

    //添加图片
    int insertFaceUserImage(FaceUserImage faceUserImage);

    //删除图片
    int deleteFaceUserImage(FaceUserImage faceUserImage);

    //通过ID查询
    FaceUserImage queryFaceUserImageByFuid(FaceUserImage faceUserImage);

    //过企业ID查询所有的人以及已经上传的图片
    List<FaceUserImage> queryFaceImageByCid(FaceUserImage faceImage);
}
