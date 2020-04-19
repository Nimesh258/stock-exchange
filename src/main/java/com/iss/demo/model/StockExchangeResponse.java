package com.iss.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class StockExchangeResponse {

	private Buyer buyers;
	private List<Seller> sellers;
	public Buyer getBuyers() {
		return buyers;
	}
	public void setBuyers(Buyer buyers) {
		this.buyers = buyers;
	}
	public List<Seller> getSellers() {
		return sellers;
	}
	public void setSellers(List<Seller> sellers) {
		this.sellers = sellers;
	}
	
	
}
