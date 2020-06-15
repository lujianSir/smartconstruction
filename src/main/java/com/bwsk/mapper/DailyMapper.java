package com.bwsk.mapper;

import com.bwsk.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyMapper {

    // 添加日报
    int insertDaily(Daily daily);

    // 修改日报
    int updateDaily(Daily daily);

    // 查询当前项目（模糊查询、通过ID查询）
    List<Daily> queryDaily(Daily daily);

    // 查询当前项目（带点赞）
    List<Daily> queryDailyThumb(Daily daily);

    // 通过当前项目下面所有天数下面所有的日报
    List<EveryDay> queryEveryDay(@Param("daily") Daily daily, @Param("dtimes") String[] dtimes);

    // 查询当前日期每个项目下面有多少日报
    List<ProjectInfo> queryProject(Daily daily);

    // 查询每个月的照片以及视频
    List<EveryDay> queryEveryDayByMonth(@Param("daily") Daily daily, @Param("creatMouths") String[] creatMouths);

    // 每天凌晨3点插入
    int insertEveryDay(EveryDay everyDay);

    // 点赞
    int insertThumb(Thumb thumb);

    // 点赞查询
    Thumb queryThumb(Thumb thumb);

    // 点赞删除
    int deleteThumb(Thumb thumb);

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

    // 通过日报ID删除评论
    void deleteCommentByDid(int did);

    // 通过日报ID删除点赞
    void deleteThumbByDid(int did);
}
