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

}
