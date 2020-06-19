package com.bwsk.service;

import com.bwsk.entity.Result;
import com.bwsk.entity.User;

/**
 * 用户模块的接口
 */
public interface UserService {

    //添加用户信息
    Result<?> insertUserMessage(User user);

    //修改用户信息
    Result<?> updateUserMessage(User user);

    //通过手机验证码或者手机密码登录
    Result<?> loginUserByTelOrPassWord(User user, String code);

    // 通过微信ID或者用户ID查询关联的信息
    User queryUserByWxIdOrUid(User user);
}
