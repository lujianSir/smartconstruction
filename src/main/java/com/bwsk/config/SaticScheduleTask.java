package com.bwsk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.bwsk.entity.EveryDay;
import com.bwsk.service.DailyService;
import com.bwsk.util.Utils;

@Configuration // 1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
public class SaticScheduleTask {

	@Autowired
	private DailyService dailyService;

	// 3.添加定时任务
	@Scheduled(cron = "0 0 3 * * ?") // 每天凌晨3:00执行任务
	// 或直接指定时间间隔，例如：5秒
	// @Scheduled(fixedRate = 5000)
	private void configureTasks() {
		String dtime = Utils.getCurrentYMD();
		String creatMouth = Utils.getCurrentMouth();
		EveryDay everyDay = new EveryDay();
		everyDay.setDtime(dtime);
		everyDay.setCreatMouth(creatMouth);
		everyDay.setDtimerub(Utils.timeStamp());
		int row = dailyService.insertEveryDay(everyDay);
		if (row > 0) {
			System.err.println("任务执行成功；执行静态定时任务时间: " + Utils.getCurrentYMD());
		} else {
			System.err.println("任务执行失败；执行静态定时任务时间: " + Utils.getCurrentYMD());
		}
	}
}
