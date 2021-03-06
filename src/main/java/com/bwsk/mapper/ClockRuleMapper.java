package com.bwsk.mapper;

import com.bwsk.entity.AddressMessage;
import com.bwsk.entity.ClockRule;
import com.bwsk.entity.ClockUser;
import com.bwsk.entity.RuleUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    //通过多个ID查询考勤地址
    List<AddressMessage> queryAddressMessageByAmids(@Param("amids") String[] amids);

    //通过企业的ID和用户的ID判断用户是否已经有绑定的打卡
    List<RuleUser> queryRuleUserByUidAndCid(@Param("cid") int cid, @Param("users") String[] users);

    List<RuleUser> queryRuleUserListByUidAndCid(@Param("cid") int cid, @Param("list") List<String> list);

    //添加打卡规则
    int insertClockRule(ClockRule clockRule);

    //修改打卡规则
    int updateClockRule(ClockRule clockRule);

    //批量添加用户与打卡
    int insertRuleUsers(List<RuleUser> list);

    //查询当前用户打卡规则
    ClockRule queryClockRuleByUidAndCid(RuleUser ruleUser);

    //判断用户是否打卡过
    ClockUser queryClockUserByUidAndCid(ClockUser clockUser);

    //添加用户打卡信息
    int insertClockUser(ClockUser clockUser);

    //修改用户打卡信息
    int updateClockUser(ClockUser clockUser);

    //查询当前用户创建过的打卡规则
    List<ClockRule> queryClockRulesByCidAndUid(ClockRule clockRule);

    //查询规则地址
    AddressMessage queryAddressMessageByAmid(int amid);

    //根据ID查询打卡规则
    ClockRule queryClockRuleByCrid(ClockRule clockRule);

    //根据CRID删除规则
    void deleteClockRule(ClockRule clockRule);

    //根据CRID删除规则与用户的绑定
    void deleteRuleUser(ClockRule clockRule);

    //查询所有的有规则的用户
    List<RuleUser> queryAllRuleUser();

    //根据日期查询当前打卡情况
    ClockUser queryClockUserByUidAndCidAndCridAndCurrentDay(ClockUser clockUser);
}
