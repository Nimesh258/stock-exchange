package com.iss.demo.model;

public class Buyer {

	private int bid;
	private String buyerName;
	private String buyerTime;
	private int buyerRate;
	private int required;
	private String orderState;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerTime() {
		return buyerTime;
	}

	public void setBuyerTime(String buyerTime) {
		this.buyerTime = buyerTime;
	}

	public int getBuyerRate() {
		return buyerRate;
	}

	public void setBuyerRate(int buyerRate) {
		this.buyerRate = buyerRate;
	}

	public int getRequired() {
		return required;
	}

	public void setRequired(int required) {
		this.required = required;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

}
