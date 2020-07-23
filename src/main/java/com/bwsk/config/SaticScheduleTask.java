package com.bwsk.config;

import com.bwsk.entity.ClockRule;
import com.bwsk.entity.ClockUser;
import com.bwsk.entity.EveryDay;
import com.bwsk.entity.RuleUser;
import com.bwsk.mapper.ClockRuleMapper;
import com.bwsk.service.DailyService;
import com.bwsk.service.WeChatService;
import com.bwsk.util.DateUtil;
import com.bwsk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration // 1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
public class SaticScheduleTask {

    @Autowired
    private DailyService dailyService;

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private ClockRuleMapper clockRuleMapper;


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

    /**
     * 每两小时获取一次access_token值,并将access_token值存入数据库中 固定时间执行
     */
//    @Scheduled(cron = "0 0 */2 * * ?")
//    //@Scheduled(fixedRate = 1000 * 30)
//    public void getAccessToken() throws IOException {
//        System.out.println("获取access_token值：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        AccessToken accessToken = CommonUtil.getAccessToken();
//        System.out.println(accessToken.getAccess_token());
//        System.out.println(accessToken.getExpires_in());
//        // 将access_token存入数据库
//        weChatService.insertAccessToken(accessToken);
//
//    }

    /**
     * 打卡
     */
    // 3.添加定时任务
    @Scheduled(cron = "0 0 3 * * ?") // 每天凌晨3:00执行任务
    // 或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate = 5000)
    private void getClockUser() throws Throwable {
        List<RuleUser> list = clockRuleMapper.queryAllRuleUser();
        List<ClockUser> clockUsers = new ArrayList<>();
        if (list.size() > 0) {
            String currentTime = DateUtil.getCurrentDate();
            for (int i = 0; i < list.size(); i++) {
                //判断规则
                RuleUser ruleUser = new RuleUser();
                ruleUser.setCrid(list.get(i).getCrid());
                ruleUser.setCid(list.get(i).getCid());
                ruleUser.setUid(list.get(i).getUid());
                ClockRule clockRule = clockRuleMapper.queryClockRuleByUidAndCid(ruleUser);

                String ruledata = clockRule.getRuledata();//获取打卡规则的日期
                int holidaystatus = clockRule.getHolidaystatus(); //法定节假日是否休息  1-休息 2-打卡
                Map<String, String> map = DateUtil.getWeeKMsg(currentTime);
                String currentdata = map.get("data");//当前星期几
                String msg = map.get("msg");// 当前是上班、周末、还是节假日
                if (holidaystatus == 1) {
                    if (msg.equals("节假日")) {
                        return;
                    }
                }
                if (ruledata.indexOf(currentdata) == -1) {//不包括  也是不在这个范围内
                    return;
                }

                ClockUser clockUser = new ClockUser();
                clockUser.setCrid(list.get(i).getCrid());
                clockUser.setCurrentday(currentTime);
                clockUser.setCid(list.get(i).getCid());
                clockUser.setUid(list.get(i).getUid());

                ClockUser cUser = clockRuleMapper.queryClockUserByUidAndCid(clockUser);
                if (cUser == null) {
                    clockRuleMapper.insertClockUser(clockUser);
                } else {
                    clockRuleMapper.updateClockUser(clockUser);
                }

            }
        }

    }
}
