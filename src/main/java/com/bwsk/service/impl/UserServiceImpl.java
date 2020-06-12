package com.bwsk.service.impl;

import com.bwsk.entity.Result;
import com.bwsk.entity.User;
import com.bwsk.mapper.UserMapper;
import com.bwsk.service.UserService;
import com.bwsk.util.JavaTool;
import com.bwsk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<?> insertUserMessage(User user) {
        User u = userMapper.queryUserMessageByTel(user);
        if (u != null) {
            return Result.error(501, "手机账号已注册");
        } else {
            String currentTime = Utils.getCurrent();
            user.setCreattime(currentTime);
            if (user.getPassword() != null && !user.getPassword().equals("")) {
                user.setPassword(JavaTool.string2MD5(user.getPassword()));
            }
            int radom = (int) (1 + Math.random() * (10 - 1 + 1));
            String pic = "/image/user/" + radom + ".png";
            user.setUpic(pic);
            int row = userMapper.insertUserMessage(user);
            if (row > 0) {
                return Result.success("注册成功");
            } else {
                return Result.error(500, "注册失败");
            }
        }

    }
}
