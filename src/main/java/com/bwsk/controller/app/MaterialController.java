package com.bwsk.controller.app;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bwsk.entity.Material;
import com.bwsk.entity.Result;
import com.bwsk.service.MaterialService;
import com.bwsk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 材料相关的接口
 *
 * @author lujian
 */
@RestController
@RequestMapping("/app/material")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    /**
     * 添加或者修改材料信息
     *
     * @param materials
     * @param pid
     * @return
     */
    @RequestMapping(value = "/insertMaterial", method = RequestMethod.POST)
    public Result<?> insertMaterial(String materials, int pid) {
        List<Material> list = new ArrayList<Material>();
        JSONArray jsonArray = JSONArray.parseArray(new String(materials));
        for (int i = 0; i < jsonArray.size(); i++) {
            Map<String, Object> m = new HashMap<String, Object>();
            Material material = new Material();
            JSONObject o = (JSONObject) jsonArray.get(i);
            Map<String, Object> map = o;
            for (Entry<String, Object> entry : map.entrySet()) {
                m.put(entry.getKey(), entry.getValue());
            }
            material.setMtname(m.get("mtname").toString());
            material.setMttime(m.get("mttime").toString());
            material.setMtremark(m.get("mtremark").toString());
            material.setMtstatus(Integer.parseInt((m.get("mtstatus").toString())));
            material.setPid(pid);
            list.add(material);
        }
//		Material material = new Material();
//		material.setMtname("钢筋222");
//		String str = "1586448000";
//		material.setMttime(Utils.timeStampDate(str, null));
//		material.setMttype(2);
//		material.setMtremark("一般般111");
//		material.setMtstatus(0);
//		material.setPid(11);
//		list.add(material);
        int row = materialService.insertMaterial(list);
        if (row > 0) {
            return Result.success("操作成功");
        } else {
            return Result.error(500, "服务端错误");
        }

    }

    /**
     * 查询所有的材料提醒
     *
     * @param material
     * @param type
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/queryMaterials", method = RequestMethod.POST)
    public Result<?> queryMaterials(Material material, int type) throws Exception {
        List<Material> list = materialService.queryMaterials(material, type);
        for (Material material2 : list) {
            material2.setMttimerub(Utils.timeToStamp(material2.getMttime()));
            if (material2.getMtstatus() == 1) {
                material2.setFlag(true);
            } else {
                material2.setFlag(false);
            }
        }
        return Result.success(list);
    }

}
