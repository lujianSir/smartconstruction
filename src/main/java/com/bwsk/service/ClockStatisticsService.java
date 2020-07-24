package com.bwsk.service;

import com.bwsk.entity.ClockStatistics;
import com.bwsk.entity.Result;

/**
 * 打卡统计
 */
public interface ClockStatisticsService {

    Result<?> queryClockStatisticsByUidAndCidAndCrid(ClockStatistics clockStatistics);
}
