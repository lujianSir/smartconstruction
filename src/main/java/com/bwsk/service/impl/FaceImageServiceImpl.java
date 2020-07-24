package com.bwsk.service.impl;

import com.baidu.aip.face.AipFace;
import com.bwsk.entity.FaceUserImage;
import com.bwsk.entity.Result;
import com.bwsk.faceutil.AiFaceObject;
import com.bwsk.faceutil.AiFaceUtil;
import com.bwsk.faceutil.Base64Convert;
import com.bwsk.faceutil.Image;
import com.bwsk.mapper.FaceImageMapper;
import com.bwsk.service.FaceImageService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@Transactional
public class FaceImageServiceImpl implements FaceImageService {

    @Autowired
    private FaceImageMapper faceImageMapper;

    @Override
    public Result<?> imageUpload(MultipartFile file, FaceUserImage faceImage, int number) {
        // TODO Auto-generated method stub
        String filePath = "";
        if (!file.isEmpty()) {
            try {
                // 文件1存放服务端的位置
                File dir = null;
                long now = System.currentTimeMillis();
                String filesuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String filename = now + filesuffix;
                String newrootPath = System.getProperty("user.dir") + "/upload";
                System.out.println(newrootPath);
                dir = new File(newrootPath + File.separator + "face" + File.separator);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                filePath = dir.getAbsolutePath() + File.separator + filename;

                // 写文件到服务器
                File serverFile = new File(filePath);
                file.transferTo(serverFile);

                //检测是否是人脸
                String msg = getFacedetection(filePath);
                System.out.println(msg.equals(""));
                if (!msg.equals("")) {//不是
                    imageDelete(filePath);
                    return Result.error(503, "照片不对");
                } else {
                    if (number == 1) {//录入
                        // 录入文件信息
                        FaceUserImage faceUserImage = new FaceUserImage();
                        faceUserImage.setUid(faceImage.getUid());
                        faceUserImage.setCid(faceImage.getCid());
                        faceUserImage.setCrid(faceImage.getCrid());
                        faceUserImage.setActualurl(filePath);
                        String fvirtualurl = "/image/face/" + filename;
                        faceUserImage.setFictitiousurl(fvirtualurl);

                        int row = faceImageMapper.insertFaceUserImage(faceUserImage);
                        if (row > 0) {
                            faceRegist(filePath, faceImage.getUid() + "", faceImage.getCid() + "_" + faceImage.getCrid());
                            return Result.success("上传成功");
                        } else {
                            return Result.error(500, "上传失败");
                        }

                    } else if (number == 2) {//打卡
                        String message = faceSearch(filePath, faceImage.getUid() + "", faceImage.getCid() + "_" + faceImage.getCrid());
                        System.out.println("打卡状态:" + message);
                        imageDelete(filePath);
                        if (message.equals("同一个人")) {
                            return Result.success("识别成功");
                        } else {
                            return Result.error(504, "识别失败");
                        }
                    } else {// 3更新人脸
                        int row = faceImageMapper.updateFaceUserImage(faceImage);
                        if (row > 0) {
                            faceUpdate(faceImage.getUid() + "", faceImage.getCid() + "_" + faceImage.getCrid(), filePath);
                            return Result.success("更新成功");
                        } else {
                            return Result.error(505, "更新失败");
                        }
                    }
                }

            } catch (Exception e) {
                imageDelete(filePath);
                return Result.error(501, "服务端错误");
            }
        } else {
            return Result.error(502, "请上传文件");
        }
    }

    @Override
    public Result<?> deleteFaceImage(FaceUserImage faceImage) {
        faceImage = faceImageMapper.queryFaceUserImageByFuid(faceImage);
        int row = faceImageMapper.deleteFaceUserImage(faceImage);
        if (row > 0) {//删除成功
            imageDelete(faceImage.getActualurl());
            faceDelete(faceImage.getUid() + "", faceImage.getCid() + "_" + faceImage.getCrid());
            return Result.success("删除成功");
        } else {
            return Result.error(500, "删除失败");
        }
    }

    @Override
    public Result<?> queryFaceImageByCid(FaceUserImage faceImage) {
        return Result.success(faceImageMapper.queryFaceImageByCid(faceImage));
    }

    //人脸检测(检测是否是人脸)
    public String getFacedetection(String realpath) {
        String message = "";
        Image image = new Image();
        String img = Base64Convert.GetImageStr(realpath);
        image.setImage(img);
        image.setImageType("BASE64");
        AipFace client = AiFaceObject.getClient();
        File f = new File(realpath);
        if (f.exists()) {
            message = AiFaceUtil.Facedetection(client, image);// 检测照片是否是对的
            if (message.equals("照片不对，需要生活照")) {
                JSONObject jsobj1 = new JSONObject();
                jsobj1.put("message", "照片不对，需要生活照");
                message = jsobj1.toString();
            } else {
                message = "";
            }
        } else {
            message = "{'message':'照片不存在'}";
        }
        return message;
    }

    //人脸注册
    public String faceRegist(String realpath, String userId, String groupId) {
        Image image = new Image();
        String img = Base64Convert.GetImageStr(realpath);
        image.setImage(img);
        image.setImageType("BASE64");
        AipFace client = AiFaceObject.getClient();
        AiFaceUtil.FaceGrouption(client, groupId);// 查询是否存在数组
        String message = AiFaceUtil.Faceregistrtion(client, groupId, userId, image);
        return message;
    }

    //人脸搜索
    public String faceSearch(String realpath, String userId, String groupId) {
        Image image = new Image();
        String img = Base64Convert.GetImageStr(realpath);
        image.setImage(img);
        image.setImageType("BASE64");
        AipFace client = AiFaceObject.getClient();
        String message = AiFaceUtil.Faceregistrtion(client, groupId, image, userId);
        System.out.println(message);
        return message;
    }

    //删除用户
    public String faceDelete(String userId, String groupId) {
        AipFace client = AiFaceObject.getClient();
        String message = AiFaceUtil.FacedeleteUser(client, groupId, userId);
        return message;
    }

    //更新用户图片
    public String faceUpdate(String userId, String groupId, String realpath) {
        AipFace client = AiFaceObject.getClient();
        Image image = new Image();
        String img = Base64Convert.GetImageStr(realpath);
        image.setImage(img);
        image.setImageType("BASE64");
        String message = AiFaceUtil.FaceUpdateUser(client, image, groupId, userId);
        return message;
    }


    //删除文件
    public String imageDelete(String fvirtualurl) {
        // TODO Auto-generated method stub
        try {
            // 删除文件
            File file = new File(fvirtualurl);
            if (file.exists()) {
                file.delete();
            }
            return "删除成功";
        } catch (Exception e) {
            return "服务端错误";
        }
    }
}
