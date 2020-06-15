package com.bwsk.entity;

import java.math.BigDecimal;

public class CollectionMoney {

	private int mid;// id

	private BigDecimal money;// 收款的金额

	private String moneychinese;// 金额中文

	private String mtime;// 收款的日期

	private String mtimerub;// 时间搓

	private String mtimechinese;// 收款日期 (年、月、日)

	private String mcomment;// 收款的内容

	private String remindcomment;// 提醒内容

	private int remindstatus;// 提醒状态

	private int mstatus;// 是否开启

	private int pid;// 项目ID

	public String getMtimerub() {
		return mtimerub;
	}

	public void setMtimerub(String mtimerub) {
		this.mtimerub = mtimerub;
	}

	public String getMoneychinese() {
		return moneychinese;
	}

	public void setMoneychinese(String moneychinese) {
		this.moneychinese = moneychinese;
	}

	public String getRemindcomment() {
		return remindcomment;
	}

	public void setRemindcomment(String remindcomment) {
		this.remindcomment = remindcomment;
	}

	public int getRemindstatus() {
		return remindstatus;
	}

	public void setRemindstatus(int remindstatus) {
		this.remindstatus = remindstatus;
	}

	public String getMtimechinese() {
		return mtimechinese;
	}

	public void setMtimechinese(String mtimechinese) {
		this.mtimechinese = mtimechinese;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	public String getMcomment() {
		return mcomment;
	}

	public void setMcomment(String mcomment) {
		this.mcomment = mcomment;
	}

	public int getMstatus() {
		return mstatus;
	}

	public void setMstatus(int mstatus) {
		this.mstatus = mstatus;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
