package com.bwsk.controller.app;

import com.bwsk.entity.*;
import com.bwsk.service.ClockRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 打卡规则
 */
@RestController
@RequestMapping("/app/rule")
public class ClockRuleController {

    @Autowired
    private ClockRuleService clockRuleService;

    /**
     * 添加打卡地址
     *
     * @param addressMessage
     * @return
     */
    @RequestMapping(value = "/insertAddreeMessage", method = RequestMethod.POST)
    public Result<?> insertAddreeMessage(AddressMessage addressMessage) {
        return clockRuleService.insertAddreeMessage(addressMessage);
    }

    /**
     * 修改打卡地址
     *
     * @param addressMessage
     * @return
     */
    @RequestMapping(value = "/updateAddreeMessageByAmId", method = RequestMethod.POST)
    public Result<?> updateAddreeMessageByAmId(AddressMessage addressMessage) {
        return clockRuleService.updateAddreeMessageByAmId(addressMessage);
    }

    /**
     * 删除打卡地址
     *
     * @param addressMessage
     * @return
     */
    @RequestMapping(value = "/deleteAddreeMessageByAmId", method = RequestMethod.POST)
    public Result<?> deleteAddreeMessageByAmId(AddressMessage addressMessage) {
        return clockRuleService.deleteAddreeMessageByAmId(addressMessage);
    }

    /**
     * 查询打卡地址
     *
     * @param addressMessage
     * @return
     */
    @RequestMapping(value = "/queryAddreeMessageByAmId", method = RequestMethod.POST)
    public Result<?> queryAddreeMessageByAmId(AddressMessage addressMessage) {
        return clockRuleService.queryAddreeMessageByAmId(addressMessage);
    }

    /**
     * 添加规则
     *
     * @param clockRule
     * @return
     */
    @RequestMapping(value = "/insertClockRule", method = RequestMethod.POST)
    public Result<?> insertClockRule(ClockRule clockRule) {
        return clockRuleService.insertClockRule(clockRule);
    }


    /**
     * 查询打卡规则
     *
     * @param currentTime
     * @param ruleUser
     * @param x2
     * @param y2
     * @return
     * @throws Throwable
     */
    @RequestMapping(value = "/queryClockRuleByUidAndCid", method = RequestMethod.POST)
    public Result<?> queryClockRuleByUidAndCid(String currentTime, RuleUser ruleUser, String x2, String y2, String msg, String currentdata) throws Throwable {
        return clockRuleService.queryClockRuleByUidAndCid(currentTime, ruleUser, x2, y2, msg, currentdata);
    }

    /**
     * 打卡操作
     *
     * @param clockUser
     * @return
     */
    @RequestMapping(value = "/insertOrUpdateClockUser", method = RequestMethod.POST)
    public Result<?> insertOrUpdateClockUser(ClockUser clockUser) throws Throwable {
        return clockRuleService.insertOrUpdateClockUser(clockUser);
    }

    /**
     * 查询当前用户创建的打卡规则
     *
     * @param clockRule
     * @return
     */
    @RequestMapping(value = "/queryClockRulesByCidAndUid", method = RequestMethod.POST)
    public Result<?> queryClockRulesByCidAndUid(ClockRule clockRule) {
        return clockRuleService.queryClockRulesByCidAndUid(clockRule);
    }

    /**
     * 根据ID查询打卡规则
     *
     * @param clockRule
     * @return
     */
    @RequestMapping(value = "/queryClockRuleByCrid", method = RequestMethod.POST)
    public Result<?> queryClockRuleByCrid(ClockRule clockRule) {
        return clockRuleService.queryClockRuleByCrid(clockRule);
    }

    /**
     * 修改打卡规则
     *
     * @param clockRule
     * @return
     */
    @RequestMapping(value = "/updateClockRule", method = RequestMethod.POST)
    public Result<?> updateClockRule(ClockRule clockRule) {
        return clockRuleService.updateClockRule(clockRule);
    }

}
