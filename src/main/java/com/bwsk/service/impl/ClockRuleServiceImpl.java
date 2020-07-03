package com.bwsk.service.impl;

import com.bwsk.entity.AddressMessage;
import com.bwsk.entity.Result;
import com.bwsk.mapper.ClockRuleMapper;
import com.bwsk.service.ClockRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClockRuleServiceImpl implements ClockRuleService {

    @Autowired
    private ClockRuleMapper clockRuleMapper;

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
}
