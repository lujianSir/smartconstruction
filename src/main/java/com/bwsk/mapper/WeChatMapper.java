package com.bwsk.mapper;

import com.bwsk.entity.AccessToken;
import org.springframework.stereotype.Repository;

@Repository
public interface WeChatMapper {
    //插入token
    int insertAccessToken(AccessToken accessToken);

    //查询最后一个token
    AccessToken queryLatestAccessToken();
}
