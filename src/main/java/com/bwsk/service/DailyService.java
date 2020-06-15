package com.bwsk.service;

import com.bwsk.entity.*;

import java.util.List;

public interface DailyService {

    // 添加获取修改日报
    int insertOrUpdateDaily(Daily daily);

    // 查询日报
    List<Daily> queryDaily(Daily daily);

    // 查询当前项目（带点赞）
    List<Daily> queryDailyThumb(Daily daily);

    // 通过日期排序查询
    List<EveryDay> queryEveryDay(Daily daily, String[] dtimes);

    // 查询当前日期每个项目下面有多少日报
    List<ProjectInfo> queryProject(Daily daily);

    // 查询每个月的照片以及视频
    List<EveryDay> queryEveryDayByMonth(Daily daily, String[] creatMouths);

    // 每天凌晨3点插入
    int insertEveryDay(EveryDay everyDay);

    // 点赞
    int insertThumb(Thumb thumb);

    // 添加评论
    int insertComment(Comment comment);

    // 根据ID以及用户ID来删除
    int deleteCommentByCmidAndCmuid(Comment comment);

    // 根据ID以及用户ID来查询
    Comment queryComment(Comment comment);

    // 分享日报
    Daily queryDailyByDidAndUid(int did, int uid);

    // 通过日报ID删除日报
    int deleteDailyByDid(int did);

}
