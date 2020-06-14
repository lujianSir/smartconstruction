package com.bwsk.mapper;

import com.bwsk.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    //添加用户信息
    int insertUserMessage(User user);

    //通过手机查询用户是否存在
    User queryUserMessageByTel(User user);

    //修改用户信息
    int updateUserMessage(User user);
}
