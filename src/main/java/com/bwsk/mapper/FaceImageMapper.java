package com.bwsk.mapper;

import com.bwsk.entity.FaceUserImage;
import org.springframework.stereotype.Repository;

@Repository
public interface FaceImageMapper {

    //添加图片
    int insertFaceUserImage(FaceUserImage faceUserImage);

    //删除图片
    int deleteFaceUserImage(FaceUserImage faceUserImage);

    //通过ID查询
    FaceUserImage queryFaceUserImageByFuid(FaceUserImage faceUserImage);
}
