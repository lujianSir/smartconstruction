package com.bwsk.service.impl;

import com.bwsk.entity.*;
import com.bwsk.mapper.DailyMapper;
import com.bwsk.service.DailyService;
import com.bwsk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyServiceImpl implements DailyService {

    @Autowired
    private DailyMapper dailyMapper;

    @Override
    public int insertOrUpdateDaily(Daily daily) {
        // TODO Auto-generated method stub
        int row = 0;
        if (daily.getDid() > 0) {// 存在 修改
            if (daily.getDtime() != null && !daily.getDtime().equals("")) {
                daily.setDtime(Utils.timeStampDateChinese(daily.getDtime(), null));
            }
            row = dailyMapper.updateDaily(daily);
        } else {// 不存在 添加
            if (daily.getDtime() != null && !daily.getDtime().equals("")) {
                daily.setDtime(Utils.timeStampDateChinese(daily.getDtime(), null));
            }
            String currentTime = Utils.getCurrent();
            daily.setCreattime(currentTime);
            daily.setCreatMouth(Utils.getCurrentMouth());
            row = dailyMapper.insertDaily(daily);
        }
        return row;
    }

    @Override
    public List<Daily> queryDaily(Daily daily) {
        // TODO Auto-generated method stub
        return dailyMapper.queryDaily(daily);
    }

    @Override
    public List<EveryDay> queryEveryDay(Daily daily, String[] dtimes) {
        // TODO Auto-generated method stub
        List<EveryDay> everyDays = dailyMapper.queryEveryDay(daily, dtimes);
        for (EveryDay everyDay : everyDays) {
            List<Daily> dailyList = everyDay.getDailyList();
            if (dailyList.get(0).getDid() == 0) {
                dailyList.clear();
            } else {
                for (Daily d : dailyList) {
                    List<Thumb> thumbs = d.getThumbs();
                    for (int m = 0; m < thumbs.size(); m++) {
                        int tuid = thumbs.get(m).getTuid();
                        if (tuid == daily.getUid()) {
                            d.setTstatus(1);
                        }
                    }
                    if (d.getUid() == daily.getUid()) {
                        everyDay.setCurrentPeople(1);

                    }

                }
            }
        }
        return everyDays;
    }

    @Override
    public List<ProjectInfo> queryProject(Daily daily) {
        // TODO Auto-generated method stub
        if (daily.getDtime() != null && !daily.getDtime().equals("")) {
            daily.setDtime(Utils.timeStampDateChinese(daily.getDtime(), null));
        }
        List<ProjectInfo> projects = dailyMapper.queryProject(daily);
        for (ProjectInfo project : projects) {
            List<Daily> dailys = project.getDailyList();
            if (dailys.get(0).getDid() == 0) {
                dailys.clear();
            } else {
                for (Daily dai : dailys) {
                    int uid = dai.getUid();
                    if (uid == daily.getUid()) {
                        project.setCurrentPeople(1);
                    }
                }
            }

        }
        return projects;
    }

    @Override
    public int insertEveryDay(EveryDay everyDay) {
        // TODO Auto-generated method stub
        return dailyMapper.insertEveryDay(everyDay);
    }

    @Override
    public List<EveryDay> queryEveryDayByMonth(Daily daily, String[] creatMouths) {
        // TODO Auto-generated method stub
        List<EveryDay> everyDays = dailyMapper.queryEveryDayByMonth(daily, creatMouths);
        for (EveryDay everyDay : everyDays) {
            List<Daily> dailyList = everyDay.getDailyList();
            if (dailyList.get(0).getDid() == 0) {
                dailyList.clear();
            }
        }
        return everyDays;
    }

    @Override
    public int insertThumb(Thumb thumb) {
        // TODO Auto-generated method stub
        int row = 0;
        Thumb t = dailyMapper.queryThumb(thumb);
        if (t == null) {// 没有就添加
            thumb.setCreattime(Utils.getCurrentHMS());
            row = dailyMapper.insertThumb(thumb);
        } else {// 有就删除
            row = dailyMapper.deleteThumb(thumb);
        }
        return row;
    }

    @Override
    public List<Daily> queryDailyThumb(Daily daily) {
        // TODO Auto-generated method stub
        List<Daily> list = dailyMapper.queryDailyThumb(daily);
        for (int i = 0; i < list.size(); i++) {
            List<Thumb> thumbs = list.get(i).getThumbs();
            if (thumbs != null && thumbs.size() > 0) {
                for (Thumb thumb : thumbs) {
                    int tuid = thumb.getTuid();
                    if (tuid == daily.getUid()) {
                        list.get(i).setTstatus(1);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public int insertComment(Comment comment) {
        // TODO Auto-generated method stub
        comment.setCmdatime(Utils.getCurrentymd());
        comment.setCreattime(Utils.getCurrentHMS());
        return dailyMapper.insertComment(comment);
    }

    @Override
    public int deleteCommentByCmidAndCmuid(Comment comment) {
        // TODO Auto-generated method stub
        return dailyMapper.deleteCommentByCmidAndCmuid(comment);
    }

    @Override
    public Comment queryComment(Comment comment) {
        // TODO Auto-generated method stub
        return dailyMapper.queryComment(comment);
    }

    @Override
    public Daily queryDailyByDidAndUid(int did, int uid) {
        // TODO Auto-generated method stub
        return dailyMapper.queryDailyByDidAndUid(did, uid);
    }

    @Override
    public int deleteDailyByDid(int did) {
        // TODO Auto-generated method stub
        dailyMapper.deleteCommentByDid(did);
        dailyMapper.deleteThumbByDid(did);
        return dailyMapper.deleteDailyByDid(did);
    }

}
