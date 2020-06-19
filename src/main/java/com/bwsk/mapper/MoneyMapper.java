package com.bwsk.mapper;

import com.bwsk.entity.CollectionMoney;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoneyMapper {

    // 添加收款
    int insertCollectionMoney(List<CollectionMoney> list);

    // 删除所有的数据
    void deleteCollectionMoney(int pid);

    // 通过项目的ID查询所有的收款信息
    List<CollectionMoney> queryCollectionMoneys(@Param("collectionMoney") CollectionMoney collectionMoney,
                                                @Param("type") int type);
}
