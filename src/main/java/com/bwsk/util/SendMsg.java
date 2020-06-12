package com.bwsk.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 腾讯手机验证码
 */
public class SendMsg {

    public static Map<String, Object> sendMsgByTxPlatform(String phone) {

        int appid = 1400382972;
        String appkey = "1f76f3cb1473de341086fa950db9ad75";
        int templateId = 633578; //这里添你申请的模板ID，注意是模板ID不是签名ID
        String smsSign = "八维时空";//这里添你申请的签名，注意不是ID，是签名，中文。
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        Map<String, Object> resultmap = new HashMap<>();
        try {
            String[] params = {checkCode, "10"};  //第一个参数传递{1}位置想要的内容，第二个传递{2}的内容，以此类推。具体看步骤5
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            TrustHttp.trustEveryone();
            SmsSingleSenderResult result = ssender.sendWithParam("86", phone,
                    templateId, params, smsSign, "", "");
            System.out.println(result);
            if (result.result == 0) {
                resultmap.put("sendCode", checkCode);
                resultmap.put("code", 200);
                resultmap.put("msg", "验证码发送成功");
            } else {
                resultmap.put("code", 500);
                resultmap.put("msg", "验证码发送失败");
            }

        } catch (Exception e) {
            resultmap.put("code", 501);
            resultmap.put("msg", "服务器异常");
        }
        return resultmap;
    }

    public static void main(String[] args) throws Exception {
        String phone = "13007188506";
        System.out.println(sendMsgByTxPlatform(phone));
    }
}
