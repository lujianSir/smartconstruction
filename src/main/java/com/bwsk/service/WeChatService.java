package com.bwsk.service;

import com.bwsk.entity.AccessToken;

import java.io.IOException;

/**
 * @author: jenkinwang
 * @date: 2018/9/27 22:17
 * @description:
 */
public interface WeChatService {

    int insertAccessToken(AccessToken accessToken);

    AccessToken queryLatestAccessToken();

    /**
     * 获取accesstoken
     *
     * @return
     * @throws IOException
     */
    String getAccessToken() throws IOException;

}
