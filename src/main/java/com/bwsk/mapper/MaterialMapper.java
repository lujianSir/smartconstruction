package com.bwsk.mapper;

import com.bwsk.entity.Material;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialMapper {

    // 添加材料
    int insertMaterial(List<Material> list);

    // 通过项目的ID查询所有的材料信息
    List<Material> queryMaterials(@Param("material") Material material, @Param("type") int type)
            throws Exception;

    // 删除所有的数据
    void deleteMaterial(int pid);

}
