package com.bwsk.service.impl;

import com.bwsk.entity.*;
import com.bwsk.mapper.ClockRuleMapper;
import com.bwsk.mapper.ClockStatisticsMapper;
import com.bwsk.service.ClockStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClockStatisticsServiceImpl implements ClockStatisticsService {

    @Autowired
    private ClockStatisticsMapper clockStatisticsMapper;

    @Autowired
    private ClockRuleMapper clockRuleMapper;

    @Override
    public Result<?> queryClockStatisticsByUidAndCidAndCrid(ClockStatistics clockStatistics) {
        List<ClockUser> list = clockStatisticsMapper.queryClockStatisticsByUidAndCidAndCrid(clockStatistics);
        if (list.size() > 0) {
            //查询当前用户打卡规则
            RuleUser ruleUser = new RuleUser();
            ruleUser.setCrid(clockStatistics.getCrid());
            ruleUser.setUid(clockStatistics.getUid());
            ruleUser.setCid(clockStatistics.getCid());
            ClockRule clockRule = clockRuleMapper.queryClockRuleByUidAndCid(ruleUser);
            int latetotal = 0; //迟到
            int earlytotal = 0;//早退
            int shortagetotal = 0;//缺卡

            for (int i = 0; i < list.size(); i++) {
                String stylename = "";
                ClockUser clockUser = list.get(i);
                //判断第一次打卡状态
                if (clockUser.getFirststatus() == 0) {
                    stylename += "mark3 ";
                    shortagetotal += 1;
                } else if (clockUser.getFirststatus() == 2) {
                    stylename += "mark1 ";
                    latetotal += 1;
                } else if (clockUser.getFirststatus() == 3) {
                    stylename += "mark2 ";
                    earlytotal += 1;
                }
                //判断第二次打卡状态
                if (clockUser.getSencondstyle() == 0) {
                    if (!stylename.contains("mark3")) {
                        stylename += "mark3 ";
                    }
                    shortagetotal += 1;
                } else if (clockUser.getSencondstyle() == 2) {
                    if (!stylename.contains("mark1")) {
                        stylename += "mark1 ";
                    }
                    latetotal += 1;
                } else if (clockUser.getSencondstyle() == 3) {
                    if (!stylename.contains("mark2")) {
                        stylename += "mark2 ";
                    }
                    earlytotal += 1;
                }

                if (clockRule.getTsstyle() == 1) {//4次打卡
                    //判断第三次打卡状态
                    if (clockUser.getThreestatus() == 0) {
                        if (!stylename.contains("mark3")) {
                            stylename += "mark3 ";
                        }
                        shortagetotal += 1;
                    } else if (clockUser.getThreestatus() == 2) {
                        if (!stylename.contains("mark1")) {
                            stylename += "mark1 ";
                        }
                        latetotal += 1;
                    } else if (clockUser.getThreestatus() == 3) {
                        if (!stylename.contains("mark2")) {
                            stylename += "mark2 ";
                        }
                        earlytotal += 1;
                    }

                    //判断第四次打卡状态
                    if (clockUser.getFourstyle() == 0) {
                        if (!stylename.contains("mark3")) {
                            stylename += "mark3 ";
                        }
                        shortagetotal += 1;
                    } else if (clockUser.getFourstyle() == 2) {
                        if (!stylename.contains("mark1")) {
                            stylename += "mark1 ";
                        }
                        latetotal += 1;
                    } else if (clockUser.getFourstyle() == 3) {
                        if (!stylename.contains("mark2")) {
                            stylename += "mark2 ";
                        }
                        earlytotal += 1;
                    }
                }
                list.get(i).setStylename(stylename);
            }
            clockStatistics.setLatetotal(latetotal);
            clockStatistics.setEarlytotal(earlytotal);
            clockStatistics.setShortagetotal(shortagetotal);
            clockStatistics.setClockUserList(list);
        }
        return Result.success(clockStatistics);
    }

    @Override
    public Result<?> queryClockUserByUidAndCidAndCridAndCurrentDay(ClockUser clockUser) {
        return Result.success(clockRuleMapper.queryClockUserByUidAndCidAndCridAndCurrentDay(clockUser));
    }

}
