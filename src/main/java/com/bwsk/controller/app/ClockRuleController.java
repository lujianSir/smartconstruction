package com.bwsk.controller.app;

import com.bwsk.entity.AddressMessage;
import com.bwsk.entity.Result;
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

}
