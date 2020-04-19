package com.iss.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iss.demo.dao.StockExchangeDao;
import com.iss.demo.model.Buyer;
import com.iss.demo.model.Seller;
import com.iss.demo.model.StockExchangeResponse;

@RestController
public class StockExchangeController {

	@Autowired
	StockExchangeDao dao;

	@Autowired
	StockExchangeResponse response;

	@PostMapping("/seller")
	public StockExchangeResponse getSeller(@RequestBody Buyer buyer) {
		List<Seller> sellers = new ArrayList<Seller>();
		Iterable<Seller> iterator = dao.findAllSorted(); //Rule:3 Seller with lesser selling rate will get more preference(sorted list will have lesser selling rate first)
		boolean firstMatch = false;
		for (Seller s : iterator) {
			sellers.add(s);
			if(buyer.getBuyerRate() < s.getSellerRate() && !firstMatch) {
				buyer.setOrderState("Pending");//Rule:6 If a buyer’s rate is less than all the sellers’ rate, then his order remains in pending state
				response.setBuyers(buyer);
			}
			else if (buyer.getBuyerRate() >= s.getSellerRate() && !firstMatch) { //Rule:1 Buyer’s required rate >= Seller’s selling rate //Rule:4 Buyer will buy from the seller(s) whose rate is the least
				if (buyer.getRequired() < s.getAvailable()) {
					s.setAvailable(s.getAvailable() - buyer.getRequired());
					buyer.setRequired(0);
				} else {
					buyer.setRequired(buyer.getRequired() - s.getAvailable());
					s.setAvailable(0);
					sellers.remove(s);
				}
				firstMatch = true;
			} else if (firstMatch && buyer.getRequired() > 0) { //Rule:2 A buyer can buy gold from more than one seller, in parts
				if (buyer.getRequired() < s.getAvailable()) {
					s.setAvailable(s.getAvailable() - buyer.getRequired());
					buyer.setRequired(0);
				} else {
					buyer.setRequired(buyer.getRequired() - s.getAvailable());
					s.setAvailable(0);
					sellers.remove(s);
				}
			}
		}
		response.setSellers(sellers);

		return response;
	}
}
