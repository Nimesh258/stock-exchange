package com.iss.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.iss.demo.model.Seller;

@RepositoryRestResource(collectionResourceRel = "sellers", path = "sellers")
public interface StockExchangeDao extends JpaRepository<Seller, Integer> {
	
	List<Seller> findBySellerRateGreaterThan(int sRate);
	
	@Query("from Seller order by seller_rate,seller_time") //Rule:5 If more than one seller is selling at the same rate then, the seller who placed their selling option earlier will get preference
	Iterable<Seller> findAllSorted();
}
