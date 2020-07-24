package com.bwsk.controller.app;

import com.bwsk.entity.ClockStatistics;
import com.bwsk.entity.ClockUser;
import com.bwsk.entity.Result;
import com.bwsk.service.ClockStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<?> queryClockStatisticsByUidAndCidAndCrid(ClockStatistics clockStatistics) {
        return clockStatisticsService.queryClockStatisticsByUidAndCidAndCrid(clockStatistics);
    }

    /**
     * 通过uid cid crid currentday查询当天打卡情况
     *
     * @param clockUser
     * @return
     */
    @RequestMapping(value = "/queryClockUserByUidAndCidAndCridAndCurrentDay", method = RequestMethod.POST)
    public Result<?> queryClockUserByUidAndCidAndCridAndCurrentDay(ClockUser clockUser) {
        return clockStatisticsService.queryClockUserByUidAndCidAndCridAndCurrentDay(clockUser);
    }
}
