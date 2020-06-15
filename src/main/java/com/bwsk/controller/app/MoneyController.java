package com.bwsk.controller.app;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bwsk.entity.CollectionMoney;
import com.bwsk.entity.Result;
import com.bwsk.service.MoneyService;
import com.bwsk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 用户相关的接口
 *
 * @author lujian
 */
@RestController
@RequestMapping("/money")
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    /**
     * 添加或者修改收款信息
     *
     * @param moneys
     * @param pid
     * @return
     */
    @RequestMapping("/insertCollectionMoney")
    public Result<?> insertCollectionMoney(String moneys, int pid) {
        List<CollectionMoney> list = new ArrayList<CollectionMoney>();
        JSONArray jsonArray = JSONArray.parseArray(new String(moneys));
        for (int i = 0; i < jsonArray.size(); i++) {
            Map<String, Object> m = new HashMap<String, Object>();
            CollectionMoney collectionMoney = new CollectionMoney();
            JSONObject o = (JSONObject) jsonArray.get(i);
            Map<String, Object> map = o;
            for (Entry<String, Object> entry : map.entrySet()) {
                m.put(entry.getKey(), entry.getValue());
            }
            collectionMoney.setMoney(new BigDecimal(m.get("money").toString()));
            collectionMoney.setMtime(m.get("date").toString());
            collectionMoney.setMcomment(m.get("content1").toString());
            collectionMoney.setMstatus(Integer.parseInt(m.get("status").toString()));
            collectionMoney.setPid(pid);
            list.add(collectionMoney);
        }
//		CollectionMoney collectionMoney = new CollectionMoney();
//		BigDecimal amountody = new BigDecimal("60");
//		collectionMoney.setMoney(amountody);
//		String str = "1586448000";
//		collectionMoney.setMtime(Utils.timeStampDate(str, null));
//		collectionMoney.setMstatus(1);
//		collectionMoney.setMcomment("测试数据");
//		collectionMoney.setPid(11);
//		list.add(collectionMoney);

        int row = moneyService.insertCollectionMoney(list);
        if (row > 0) {
            return Result.success("操作成功");
        } else {
            return Result.error(500, "服务端错误");
        }

    }

    /**
     * 查询所有的收款提醒
     *
     * @param collectionMoney
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryCollectionMoneys")
    public Result<?> queryCollectionMoneys(CollectionMoney collectionMoney, int type) throws Exception {
        List<CollectionMoney> list = moneyService.queryCollectionMoneys(collectionMoney, type);
        for (CollectionMoney collectionMoney2 : list) {
            collectionMoney2.setMtimerub(Utils.timeToStamp(collectionMoney2.getMtime()));
        }
        return Result.success(list);
    }

}
