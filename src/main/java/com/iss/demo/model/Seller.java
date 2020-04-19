package com.iss.demo.model;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seller {

	@Id
	private int sid;
	private String sellerName;
	private Time sellerTime;
	private int sellerRate;
	private int available;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Time getSellerTime() {
		return sellerTime;
	}

	public void setSellerTime(Time sellerTime) {
		this.sellerTime = sellerTime;
	}

	public int getSellerRate() {
		return sellerRate;
	}

	public void setSellerRate(int sellerRate) {
		this.sellerRate = sellerRate;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Seller [sid=" + sid + ", sellerName=" + sellerName + ", sellerTime=" + sellerTime + ", sellerRate="
				+ sellerRate + ", available=" + available + "]";
	}

}
