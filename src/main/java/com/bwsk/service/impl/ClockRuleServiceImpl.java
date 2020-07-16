package com.bwsk.service.impl;

import com.bwsk.entity.*;
import com.bwsk.mapper.ClockRuleMapper;
import com.bwsk.mapper.DeptMapper;
import com.bwsk.service.ClockRuleService;
import com.bwsk.util.DateUtil;
import com.bwsk.util.LocationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClockRuleServiceImpl implements ClockRuleService {

    @Autowired
    private ClockRuleMapper clockRuleMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Result<?> insertAddreeMessage(AddressMessage addressMessage) {
        int row = clockRuleMapper.insertAddreeMessage(addressMessage);
        if (row > 0) {
            return Result.success(addressMessage);
        } else {
            return Result.error(500, "添加失败");
        }
    }

    @Override
    public Result<?> updateAddreeMessageByAmId(AddressMessage addressMessage) {
        int row = clockRuleMapper.updateAddreeMessageByAmId(addressMessage);
        if (row > 0) {
            return Result.success("修改成功");
        } else {
            return Result.error(500, "修改失败");
        }
    }

    @Override
    public Result<?> deleteAddreeMessageByAmId(AddressMessage addressMessage) {
        int row = clockRuleMapper.deleteAddreeMessageByAmId(addressMessage);
        if (row > 0) {
            return Result.success("删除成功");
        } else {
            return Result.error(500, "删除失败");
        }
    }

    @Override
    public Result<?> queryAddreeMessageByAmId(AddressMessage addressMessage) {
        addressMessage = clockRuleMapper.queryAddreeMessageByAmId(addressMessage);
        return Result.success(addressMessage);
    }

    @Override
    public Result<?> insertClockRule(ClockRule clockRule) {
        int cid = clockRule.getCid();
        List<RuleUser> list;
        String msg = "";
        if (clockRule.getUsers() != null && !clockRule.getUsers().equals("")) {//判断添加企业用户是否已经存在规则
            String[] users = clockRule.getUsers().split(",");
            list = clockRuleMapper.queryRuleUserByUidAndCid(cid, users);
            if (list.size() > 0) {
                msg += "用户：";
                for (int i = 0; i < list.size(); i++) {
                    msg += list.get(i).getUsername() + "已存在" + list.get(i).getCrname();
                    if (i < list.size() - 1) {
                        msg += ",";
                    }
                }
                msg += "，请解除相应的绑定!";
                return Result.error(500, msg);
            }
        }
        if (clockRule.getDeptids() != null && !clockRule.getDeptids().equals("")) {//判断该企业、部门下面的用户是否已经存在打卡规则
            List<String> deptusers = new ArrayList<String>();
            String[] clocks = clockRule.getDeptids().split(",");//获取所有的部门
            for (int i = 0; i < clocks.length; i++) {
                int deptid = Integer.parseInt(clocks[i]);
                List<DeptUser> deptUsers = deptMapper.queryUserByDeptId(deptid);
                if (deptUsers.size() > 0) {
                    for (DeptUser deptUser : deptUsers) {
                        deptusers.add(deptUser.getUid() + "");
                    }
                }
            }
            list = clockRuleMapper.queryRuleUserListByUidAndCid(cid, deptusers);
            if (list.size() > 0) {
                msg += "用户：";
                for (int i = 0; i < list.size(); i++) {
                    msg += list.get(i).getUsername() + "已存在" + list.get(i).getCrname();
                    if (i < list.size() - 1) {
                        msg += ",";
                    }
                }
                msg += "，请解除相应的绑定!";
                return Result.error(501, msg);
            }
            clockRule.setUsers(deptusers.toString());
        }
        int row = clockRuleMapper.insertClockRule(clockRule);
        if (clockRule.getUsers() != null && !clockRule.getUsers().equals("")) {
            String[] users = clockRule.getUsers().split(",");
            List<RuleUser> ruleUsers = new ArrayList<RuleUser>();
            for (int m = 0; m < users.length; m++) {
                RuleUser ruleUser = new RuleUser();
                ruleUser.setUid(Integer.parseInt(users[m]));
                ruleUser.setCid(cid);
                ruleUser.setCrid(clockRule.getCrid());
                ruleUsers.add(ruleUser);
            }
            clockRuleMapper.insertRuleUsers(ruleUsers);
        }
        if (row > 0) {
            return Result.success("添加成功");
        } else {
            return Result.error(500, "添加失败");
        }
    }

    @Override
    public Result<?> updateClockRule(ClockRule clockRule) {
        clockRuleMapper.updateClockRule(clockRule);
        return Result.success("操作成功");
    }

    @Override
    public Result<?> queryClockRuleByCrid(ClockRule clockRule) {
        ClockRule rule = clockRuleMapper.queryClockRuleByCrid(clockRule);
        String amid = rule.getAmids();
        String[] amids = amid.split(",");
        List<AddressMessage> addressMessageList = clockRuleMapper.queryAddressMessageByAmids(amids);
        rule.setAddressMessageList(addressMessageList);
        return Result.success(rule);
    }

    @Override
    public Result<?> queryClockRulesByCidAndUid(ClockRule clockRule) {
        List<ClockRule> list = clockRuleMapper.queryClockRulesByCidAndUid(clockRule);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ClockRule crule = list.get(i);
                if (crule.getUserrulestyle() == 1) {
                    list.get(i).setUserrulestylename("人员");
                } else {
                    list.get(i).setUserrulestylename("部门");
                }
                String ids = crule.getAmids();
                String[] amids = ids.split(",");
                List<AddressMessage> addressMessages = clockRuleMapper.queryAddressMessageByAmids(amids);
                list.get(i).setTotalamid(addressMessages.size());
                list.get(i).setAmids(addressMessages.get(0).getAmname() + "(" + addressMessages.get(0).getAmrange() + ")米" + addressMessages.get(0).getAmdetail());
            }
        }
        return Result.success(list);
    }

    @Override
    public Result<?> queryClockRuleByUidAndCid(String currentTime, RuleUser ruleUser, String x2, String y2, String msg, String currentdata) throws Throwable {
        ClockRule clockRule = clockRuleMapper.queryClockRuleByUidAndCid(ruleUser);
        //判断该用户是否存在打卡规则
        if (clockRule == null) {
            return Result.error(500, "当前没有打卡规则，请联系管理员!");
        }
        String ruledata = clockRule.getRuledata();//获取打卡规则的日期
        int holidaystatus = clockRule.getHolidaystatus(); //法定节假日是否休息  1-休息 2-打卡
        //       Map<String, String> map = DateUtil.getWeeKMsg(currentTime);
//        String currentdata = map.get("data");//当前星期几
//        String msg = map.get("msg");// 当前是上班、周末、还是节假日
        if (holidaystatus == 1) {
            if (msg.equals("节假日")) {
                return Result.error(501, "节假日不需要打卡");
            }
        }
        if (ruledata.indexOf(currentdata) == -1) {//不包括  也是不在这个范围内
            return Result.error(502, "周末不需要打卡");
        }

        //判断是否在打卡范围内
        String amids = clockRule.getAmids();//获取当前打卡的范围
        List<AddressMessage> addressMessages = new ArrayList<AddressMessage>();
        if (amids != null && !amids.equals("")) {
            String[] ids = amids.split(",");
            addressMessages = clockRuleMapper.queryAddressMessageByAmids(ids);
        }
        if (addressMessages.size() > 0) {
            for (int i = 0; i < addressMessages.size(); i++) {
                String x1 = addressMessages.get(i).getAmlongitude();//获取经度
                String y1 = addressMessages.get(i).getAmlatitude();//获取纬度
                boolean flag = LocationUtils.checkDistance(Double.parseDouble(x1), Double.parseDouble(y1), Double.parseDouble(x2), Double.parseDouble(y2), addressMessages.get(i).getAmrange());
                if (flag) {
                    clockRule.setFlag(true);
                    break;
                }
            }
        }
        //判断当日是否已经打卡过
        ClockUser clockUser = new ClockUser();
        clockUser.setCurrentday(currentTime.substring(0, 9));
        clockUser.setUid(ruleUser.getUid());
        clockUser.setCid(ruleUser.getCid());
        clockUser.setCurrentday(currentTime);
        ClockUser cUser = clockRuleMapper.queryClockUserByUidAndCid(clockUser);
        if (cUser == null) {
            clockRuleMapper.insertClockUser(clockUser);
            clockRule.setClockUser(clockUser);
        } else {
            clockRule.setClockUser(cUser);
        }

        return Result.success(clockRule);
    }

    @Override
    public Result<?> insertOrUpdateClockUser(ClockUser clockUser) throws Throwable {
        RuleUser ruleUser = new RuleUser();
        ruleUser.setCrid(clockUser.getCrid());
        ruleUser.setUid(clockUser.getUid());
        ruleUser.setCid(clockUser.getCid());
        ClockRule cRule = clockRuleMapper.queryClockRuleByUidAndCid(ruleUser);
        if (cRule.getTsstyle() == 1) {//4次打卡
            String standardfourtime = cRule.getFourtime();//标准最后一次打卡时间
            if (standardfourtime != null && !standardfourtime.equals("")) {//到最后一次打卡
                if (clockUser.getFourstyle() == 1) {//正常打卡  为2则早退 不存在加班
                    String actualfourtime = clockUser.getFourtime();//实际最后一次打卡时间
                    String min = DateUtil.getHour(clockUser.getCurrentday() + " " + standardfourtime, clockUser.getCurrentday() + " " + actualfourtime, "yyyy-MM-dd HH:mm");
                    clockUser.setWorkovertime(min);
                }
            }

        } else {//2次打卡
            String standardsecondtime = cRule.getSencondtime();//标准最后一次打卡时间
            if (standardsecondtime != null && !standardsecondtime.equals("")) {
                if (clockUser.getSencondstyle() == 1) {//正常打卡  为2则早退 不存在加班
                    String actualsecondtime = clockUser.getSencondtime();//
                    String min = DateUtil.getHour(clockUser.getCurrentday() + standardsecondtime, clockUser.getCurrentday() + actualsecondtime, "yyyy-MM-dd HH:mm");
                    clockUser.setWorkovertime(min);
                }
            }
        }

        int row = 0;
        if (clockUser.getCuid() > 0) {//修改
            row = clockRuleMapper.updateClockUser(clockUser);
        } else {//添加
            row = clockRuleMapper.insertClockUser(clockUser);
        }
        if (row > 0) {
            return Result.success("打卡成功");
        } else {
            return Result.error(500, "打卡失败");
        }

    }

    @Override
    public Result<?> deleteClockRule(ClockRule clockRule) {
        clockRuleMapper.deleteClockRule(clockRule);
        clockRuleMapper.deleteRuleUser(clockRule);
        return Result.success("删除成功");
    }
}
