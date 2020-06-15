package com.bwsk.entity;

import java.math.BigDecimal;
import java.util.List;

public class DailyStatistic extends Project {

	private int dailyTody;// 日报天数

	private int dailyTotal;// 日报总数

	private BigDecimal amountodyTotal;// 累计收款

	private BigDecimal invoicetodyTotal;// 累计开票

	private int totalPeople;// 累计人工

	private List<Equipment> equipments;// 装备材料

	public BigDecimal getAmountodyTotal() {
		return amountodyTotal;
	}

	public void setAmountodyTotal(BigDecimal amountodyTotal) {
		this.amountodyTotal = amountodyTotal;
	}

	public BigDecimal getInvoicetodyTotal() {
		return invoicetodyTotal;
	}

	public void setInvoicetodyTotal(BigDecimal invoicetodyTotal) {
		this.invoicetodyTotal = invoicetodyTotal;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public int getDailyTody() {
		return dailyTody;
	}

	public void setDailyTody(int dailyTody) {
		this.dailyTody = dailyTody;
	}

	public int getDailyTotal() {
		return dailyTotal;
	}

	public void setDailyTotal(int dailyTotal) {
		this.dailyTotal = dailyTotal;
	}

	public int getTotalPeople() {
		return totalPeople;
	}

	public void setTotalPeople(int totalPeople) {
		this.totalPeople = totalPeople;
	}

}
