package com.bwsk.service;

import com.bwsk.entity.CollectionMoney;

import java.util.List;

public interface MoneyService {

    // 添加收款
    int insertCollectionMoney(List<CollectionMoney> list);

    // 通过项目的ID查询所有的收款信息
    List<CollectionMoney> queryCollectionMoneys(CollectionMoney collectionMoney, int type) throws Exception;
}
