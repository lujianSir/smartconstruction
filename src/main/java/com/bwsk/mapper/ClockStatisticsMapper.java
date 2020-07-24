package com.bwsk.mapper;

import com.bwsk.entity.ClockStatistics;
import com.bwsk.entity.ClockUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClockStatisticsMapper {
    List<ClockUser> queryClockStatisticsByUidAndCidAndCrid(ClockStatistics clockStatistics);
}
