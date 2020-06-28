package com.bwsk.service.impl;

import com.bwsk.entity.AccessToken;
import com.bwsk.mapper.WeChatMapper;
import com.bwsk.service.WeChatService;
import com.bwsk.util.CommonUtil;
import com.bwsk.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author: jenkinwang
 * @date: 2018/9/27 22:17
 * @description:
 */
@Service
public class WeChatServiceImpl implements WeChatService {

    @Autowired
    private WeChatMapper weChatMapper;


    @Override
    public int insertAccessToken(AccessToken accessToken) {
        return weChatMapper.insertAccessToken(accessToken);
    }

    @Override
    public AccessToken queryLatestAccessToken() {
        return weChatMapper.queryLatestAccessToken();
    }

    @Override
    public String getAccessToken() throws IOException {
        // TODO Auto-generated method stub
        AccessToken accessToken = weChatMapper.queryLatestAccessToken();
        if (accessToken != null) {
            long curMillis = DateUtil.getCurrentMillis();
            long myCustomMillis = DateUtil.getCustomDateMillis(accessToken.getCreate_time());
            if ((curMillis - myCustomMillis) / 1000 >= 7200) {
                System.out.println("access_token值已过期，重新获取并入库......");
                accessToken = CommonUtil.getAccessToken();
                weChatMapper.insertAccessToken(accessToken);
            }
        } else {
            accessToken = CommonUtil.getAccessToken();
            weChatMapper.insertAccessToken(accessToken);
        }
        return accessToken.getAccess_token();
    }

}
