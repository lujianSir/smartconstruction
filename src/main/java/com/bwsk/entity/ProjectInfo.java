package com.bwsk.entity;

import java.util.List;

public class ProjectInfo {

	private int pid;// id

	private String pname;// 项目名称

	private String weixin;// 项目绑定的微信ID

	private int currentPeople;// 判断当前用户是否已经提交

	private List<Daily> dailyList;// 当前时间不同公司下面多个日报

	public int getCurrentPeople() {
		return currentPeople;
	}

	public void setCurrentPeople(int currentPeople) {
		this.currentPeople = currentPeople;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public List<Daily> getDailyList() {
		return dailyList;
	}

	public void setDailyList(List<Daily> dailyList) {
		this.dailyList = dailyList;
	}

}
