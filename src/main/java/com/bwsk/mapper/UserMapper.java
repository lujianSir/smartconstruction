package com.bwsk.mapper;

import com.bwsk.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //添加用户信息
    int insertUserMessage(User user);

    //通过手机查询用户是否存在
    User queryUserMessageByTel(User user);

    //修改用户信息
    int updateUserMessage(User user);

    // 通过项目ID以及用户ID查询用户
    List<User> queryUserByUidAndPid(@Param("uid") int uid, @Param("pid") int pid);

    //通过手机或者ID查询用户信息
    User queryUserByUidOrTel(User user);
}
