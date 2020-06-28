package com.bwsk.controller.app;

import com.bwsk.entity.AccessToken;
import com.bwsk.entity.Result;
import com.bwsk.service.WeChatService;
import com.bwsk.util.CommonUtil;
import com.bwsk.util.DateUtil;
import com.bwsk.util.WeChatVerificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: jenkinwang
 * @date: 2018/9/25 23:18
 * @description:
 */
@RestController
@RequestMapping("/app/wechat")
public class WeChatController {

    @Autowired
    private WeChatService weChatService;

    /**
     * 验证消息来自于服务器
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @param request
     * @param response
     */
    @RequestMapping(value = "/verificate", method = RequestMethod.GET)
    public void weChatVerification(@RequestParam String signature, @RequestParam String timestamp, @RequestParam String nonce, @RequestParam String echostr,
                                   HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, String> map = new HashMap<String, String>();

        String _signature = WeChatVerificationUtil.verificateWX(timestamp, nonce);
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        map.put("signature", signature);
        map.put("timestamp", timestamp);
        map.put("nonce", nonce);
        PrintWriter printWriter = response.getWriter();
        // 对比signature
        if (signature.equals(_signature)) {
            System.out.println("success");
            printWriter.print(echostr);
        } else {
            System.out.println("fail");
        }
    }

    /**
     * 手动获取access_token值: 如果当前时间与数据库里的最新access_token值的时间相差大于7200秒，则access_token过期，需要重新获取access_token值，并入库
     *
     * @return
     * @throws IOException
     */
    public String queryLatestAccessToken() throws IOException {
        AccessToken accessToken = weChatService.queryLatestAccessToken();

        long curMillis = DateUtil.getCurrentMillis();
        long myCustomMillis = DateUtil.getCustomDateMillis(accessToken.getCreate_time());
        if ((curMillis - myCustomMillis) / 1000 >= 7200) {
            System.out.println("access_token值已过期，重新获取并入库......");
            accessToken = CommonUtil.getAccessToken();
            weChatService.insertAccessToken(accessToken);
        }

        return accessToken.getAccess_token();
    }

    /**
     * 获取jsconfig
     *
     * @param
     * @return
     */
    @RequestMapping(value = "getConfigMessage")
    public Result<?> getConfigMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String accessToken = weChatService.getAccessToken();
        Map<String, Object> map = CommonUtil.getJsapiConfig(request, accessToken);
        return Result.success(map);
    }

}
