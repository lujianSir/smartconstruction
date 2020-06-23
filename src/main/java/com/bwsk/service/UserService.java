package com.bwsk.service;

import com.bwsk.entity.Result;
import com.bwsk.entity.User;

import java.util.List;

/**
 * 用户模块的接口
 */
public interface UserService {

    //添加用户信息
    Result<?> insertUserMessage(User user);

    //修改用户信息
    Result<?> updateUserMessage(User user);

    Result<?> updateUserMessageByUid(User user);

    //通过手机验证码或者手机密码登录
    Result<?> loginUserByTelOrPassWord(User user, String code);

    // 通过项目ID以及用户ID查询用户
    List<User> queryUserByUidAndPid(int uid, int pid);

    //通过手机或者ID查询用户信息
    Result<?> queryUserByUidOrTel(User user);

}
