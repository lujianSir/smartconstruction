package com.bwsk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwsk.entity.CollectionMoney;
import com.bwsk.mapper.MoneyMapper;
import com.bwsk.service.MoneyService;
import com.bwsk.util.ConvertUpMoney;
import com.bwsk.util.Utils;

@Service
public class MoneyServiceImpl implements MoneyService {

	@Autowired
	private MoneyMapper moneyMapper;

	@Override
	public int insertCollectionMoney(List<CollectionMoney> list) {
		// TODO Auto-generated method stub
		moneyMapper.deleteCollectionMoney();
		int row = moneyMapper.insertCollectionMoney(list);
		return row;
	}

	@Override
	public List<CollectionMoney> queryCollectionMoneys(CollectionMoney collectionMoney, int type) throws Exception {
		// TODO Auto-generated method stub
		List<CollectionMoney> collectionMoneys = moneyMapper.queryCollectionMoneys(collectionMoney, type);
		for (CollectionMoney money : collectionMoneys) {
			String mtime = money.getMtime();
			String timeStemp = Utils.timeToStamp(mtime);// 时间错
			String datechinese = Utils.timeStampDateChinese(timeStemp, null);
			String currentymd = Utils.getCurrentymd();
			Map<String, Object> map = Utils.getDistanceDays(mtime, currentymd);
			money.setMtimechinese(datechinese);
			money.setRemindcomment(map.get("content").toString());
			money.setRemindstatus(Integer.parseInt(map.get("status").toString()));
			money.setMoneychinese(ConvertUpMoney.toChinese(money.getMoney() + ""));
		}
		return collectionMoneys;
	}

}
