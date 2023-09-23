package com.hkjava.demo.demofinnhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hkjava.demo.demofinnhub.entity.StockPrice;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {

}
