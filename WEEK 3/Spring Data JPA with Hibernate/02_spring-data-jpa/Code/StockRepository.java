package com.cognizant.ormlearn.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.ormlearn.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {

	// FB stocks in Sep 2019
	List<Stock> findByCodeAndDateBetween(String code, Date start, Date end);

	// GOOGL stocks where close > 1250
	List<Stock> findByCodeAndCloseGreaterThan(String code, double close);

	// top 3 by highest volume
	List<Stock> findTop3ByOrderByVolumeDesc();

	// top 3 Netflix stocks with lowest close price
	List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
