package com.bwsk.controller.app;

import com.bwsk.entity.ClockStatistics;
import com.bwsk.entity.ClockUser;
import com.bwsk.entity.Result;
import com.bwsk.service.ClockStatisticsService;
import com.bwsk.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * 收款相关的接口
 *
 * @author lujian
 */
@RestController
@RequestMapping("/app/statisctic")
public class ClockStatisticsController {

    @Autowired
    private ClockStatisticsService clockStatisticsService;

    /**
     * 统计不正常
     *
     * @param clockStatistics
     * @return
     */
    @RequestMapping(value = "/queryClockStatisticsByUidAndCidAndCrid", method = RequestMethod.POST)
    public Result<?> queryClockStatisticsByUidAndCidAndCrid(ClockStatistics clockStatistics) throws ParseException {
        clockStatistics.setStarttime(DateUtil.getStringDate(DateUtil.parseStringToDate1(clockStatistics.getStarttime())));
        clockStatistics.setEndtime(DateUtil.getStringDate(DateUtil.parseStringToDate1(clockStatistics.getEndtime())));
        return clockStatisticsService.queryClockStatisticsByUidAndCidAndCrid(clockStatistics);
    }

    /**
     * 通过uid cid crid currentday查询当天打卡情况
     *
     * @param clockUser
     * @return
     */
    @RequestMapping(value = "/queryClockUserByUidAndCidAndCridAndCurrentDay", method = RequestMethod.POST)
    public Result<?> queryClockUserByUidAndCidAndCridAndCurrentDay(ClockUser clockUser) throws ParseException {
        clockUser.setCurrentday(DateUtil.getStringDate(DateUtil.parseStringToDate1(clockUser.getCurrentday())));
        return clockStatisticsService.queryClockUserByUidAndCidAndCridAndCurrentDay(clockUser);
    }
}
