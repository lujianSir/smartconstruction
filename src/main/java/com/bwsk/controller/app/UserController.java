package com.bwsk.controller.app;

import com.bwsk.entity.Result;
import com.bwsk.entity.User;
import com.bwsk.service.UserService;
import com.bwsk.util.SendMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 用户相关的接口
 *
 * @author lujian
 */
@RestController
@RequestMapping("/app/user")
public class UserController {

    @Autowired
    public StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserService userService;

    /**
     * 获取验证码
     *
     * @param utelphone
     * @return
     */
    @RequestMapping(value = "/getCheckCode", method = RequestMethod.POST)
    public Result<?> getCheckCode(String utelphone) {
        Map<String, Object> map = SendMsg.sendMsgByTxPlatform(utelphone);
        if (Integer.parseInt(map.get("code").toString()) == 200) {
            stringRedisTemplate.opsForValue().set(utelphone, map.get("sendCode").toString(), 60 * 10, TimeUnit.SECONDS);
            return Result.success(map.get("sendCode"));
        } else if (Integer.parseInt(map.get("code").toString()) == 501) {
            return Result.error(500, map.get("msg").toString());
        } else {
            return Result.error(501, map.get("msg").toString());
        }
    }

    /**
     * 添加用户
     *
     * @param user
     * @param code
     * @return
     */
    @RequestMapping(value = "inserUserMessage", method = RequestMethod.POST)
    public Result<?> insertUserMessage(User user, String code) {
        if (code != null && !code.equals("")) {
            String checkCode = stringRedisTemplate.opsForValue().get(user.getUtelphone());
            if (checkCode != null && !checkCode.equals("")) {
                if (checkCode.equals(code)) {
                    return userService.insertUserMessage(user);
                } else {
                    return Result.error(503, "验证码不对，请重新输入");
                }

            } else {
                return Result.error(502, "验证码过期，请重新发起");
            }
        } else {
            return Result.error(501, "验证码不能为空");
        }
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "updateUserMessage", method = RequestMethod.POST)
    public Result<?> updateUserMessage(User user) {

        return userService.updateUserMessage(user);
    }

    /**
     * 通过ID修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "updateUserMessageByUid", method = RequestMethod.POST)
    public Result<?> updateUserMessageByUid(User user) {

        return userService.updateUserMessageByUid(user);
    }

    /**
     * 通过验证码或者密码登录
     *
     * @param user
     * @param code
     * @return
     */
    @RequestMapping(value = "loginUserByTelOrPassWord", method = RequestMethod.POST)
    public Result<?> loginUserByTelOrPassWord(User user, String code) {

        return userService.loginUserByTelOrPassWord(user, code);
    }

    /**
     * 通过项目ID以及用户ID查询用户
     *
     * @param uid
     * @param pid
     * @return
     */
    @RequestMapping(value = "/queryUserByUidAndPid", method = RequestMethod.POST)
    public Result<?> queryUserByUidAndPid(int uid, int pid) {
        List<User> list = userService.queryUserByUidAndPid(uid, pid);
        return Result.success(list);
    }

    /**
     * 通过手机或者ID查询用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/queryUserByUidOrTel", method = RequestMethod.POST)
    public Result<?> queryUserByUidOrTel(User user) {
        return userService.queryUserByUidOrTel(user);
    }

    /**
     * 查询所有的默认图片
     *
     * @return
     */
    @RequestMapping(value = "/queryImageUrls", method = RequestMethod.POST)
    public Result<?> queryImageUrls() {
        return userService.queryImageUrls();
    }
}
