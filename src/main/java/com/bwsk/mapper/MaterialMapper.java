package com.bwsk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bwsk.entity.Material;

@Repository
public interface MaterialMapper {

	// 添加材料
	public int insertMaterial(List<Material> list);

	// 通过项目的ID查询所有的材料信息
	public List<Material> queryMaterials(@Param("material") Material material, @Param("type") int type)
			throws Exception;

	// 删除所有的数据
	public void deleteMaterial();

}
