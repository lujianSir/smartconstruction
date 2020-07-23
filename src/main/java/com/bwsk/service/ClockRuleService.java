package com.bwsk.service;

import com.bwsk.entity.*;

import java.util.List;

public interface ClockRuleService {

    //添加考勤地点信息
    Result<?> insertAddreeMessage(AddressMessage addressMessage);

    //根据ID修改考勤地点的信息
    Result<?> updateAddreeMessageByAmId(AddressMessage addressMessage);

    //根据ID删除考勤地址
    Result<?> deleteAddreeMessageByAmId(AddressMessage addressMessage);

    //根据ID查询考勤地址
    Result<?> queryAddreeMessageByAmId(AddressMessage addressMessage);


    //添加打卡规则
    Result<?> insertClockRule(ClockRule clockRule);

    //修改打卡规则
    Result<?> updateClockRule(ClockRule clockRule);

    //根据ID查询打卡规则
    Result<?> queryClockRuleByCrid(ClockRule clockRule);

    //查询当前用户创建过的打卡规则
    Result<?> queryClockRulesByCidAndUid(ClockRule clockRule);

    //查询当前用户的打卡规则
    Result<?> queryClockRuleByUidAndCid(String currentTime, RuleUser ruleUser, String x2, String y2, String msg, String currentdata) throws Throwable;

    //打卡操作
    Result<?> insertOrUpdateClockUser(ClockUser clockUser) throws Throwable;

    //删除打卡规则
    Result<?> deleteClockRule(ClockRule clockRule);

    //查询所有的有规则的用户
    List<RuleUser> queryAllRuleUser();

}
