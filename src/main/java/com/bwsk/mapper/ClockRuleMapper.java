package com.bwsk.mapper;

import com.bwsk.entity.AddressMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface ClockRuleMapper {

    //添加考勤位置信息
    int insertAddreeMessage(AddressMessage addressMessage);

    //根据ID修改考勤地点的信息
    int updateAddreeMessageByAmId(AddressMessage addressMessage);

    //根据ID删除考勤地址
    int deleteAddreeMessageByAmId(AddressMessage addressMessage);

    //根据ID查询考勤地址
    AddressMessage queryAddreeMessageByAmId(AddressMessage addressMessage);
}
