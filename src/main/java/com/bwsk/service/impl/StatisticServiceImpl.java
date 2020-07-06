package com.bwsk.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bwsk.entity.Daily;
import com.bwsk.entity.DailyStatistic;
import com.bwsk.entity.Equipment;
import com.bwsk.entity.Statistic;
import com.bwsk.mapper.StatisticMapper;
import com.bwsk.service.StatisticService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

    @Resource
    private StatisticMapper statisticMapper;

    @Override
    public List<Statistic> queryWeacher(Daily daily) {
        // TODO Auto-generated method stub
        return statisticMapper.queryWeacher(daily);
    }

    @Override
    public List<Statistic> queryAttendancetody(Daily daily) {
        // TODO Auto-generated method stub
        return statisticMapper.queryAttendancetody(daily);
    }

    @Override
    public List<DailyStatistic> queryDailyStatistic(Daily daily) {
        // TODO Auto-generated method stub
        List<DailyStatistic> list = statisticMapper.queryDailyStatistic(daily);
        List<Daily> dailys = statisticMapper.queryDailyEquipment(daily);
        List<Equipment> eqs = new ArrayList<Equipment>();
        for (int i = 0; i < dailys.size(); i++) {
            String equipments = dailys.get(i).getEquipments();
            JSONArray jsonArray = JSONArray.parseArray(new String(equipments));
            for (int p = 0; p < jsonArray.size(); p++) {
                Map<String, Object> m = new HashMap<String, Object>();
                Equipment equipment = new Equipment();
                JSONObject o = (JSONObject) jsonArray.get(p);
                Map<String, Object> map = o;
                for (Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() == null || entry.getValue().toString().equals("")) {
                        break;
                    } else {
                        m.put(entry.getKey(), entry.getValue());
                    }

                }
                if (m.get("namex") != null && !m.get("namex").equals("")) {
                    equipment.setNamex(m.get("namex").toString());

                    if (m.get("countx") != null && !m.get("countx").equals("")) {
                        equipment.setCountx(Integer.parseInt(m.get("countx").toString()));
                        eqs.add(equipment);
                    }

                }

            }

        }
        list.get(0).setEquipments(eqs);
        return list;
    }

    @Override
    public List<DailyStatistic> queryDailyStatisticByUid(Daily daily) {
        // TODO Auto-generated method stub
        List<DailyStatistic> list = statisticMapper.queryDailyStatisticByUid(daily);
        List<Daily> dailys = statisticMapper.queryDailyEquipment(daily);
        List<Equipment> eqs = new ArrayList<Equipment>();
        for (int i = 0; i < dailys.size(); i++) {
            String equipments = dailys.get(i).getEquipments();
            JSONArray jsonArray = JSONArray.parseArray(new String(equipments));
            for (int p = 0; p < jsonArray.size(); p++) {
                Map<String, Object> m = new HashMap<String, Object>();
                Equipment equipment = new Equipment();
                JSONObject o = (JSONObject) jsonArray.get(p);
                Map<String, Object> map = o;
                for (Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() == null || entry.getValue().toString().equals("")) {
                        break;
                    } else {
                        m.put(entry.getKey(), entry.getValue());
                    }

                }
                if (m.get("namex") != null && !m.get("namex").equals("")) {
                    equipment.setNamex(m.get("namex").toString());

                    if (m.get("countx") != null && !m.get("countx").equals("")) {
                        equipment.setCountx(Integer.parseInt(m.get("countx").toString()));
                        eqs.add(equipment);
                    }

                }

            }

        }
        list.get(0).setEquipments(eqs);
        return list;
    }

    @Override
    public List<Daily> queryDailyByUid(Daily daily) {
        // TODO Auto-generated method stub
        return statisticMapper.queryDailyByUid(daily);
    }

}
