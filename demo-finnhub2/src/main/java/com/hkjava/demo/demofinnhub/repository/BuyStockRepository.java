package com.hkjava.demo.demofinnhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hkjava.demo.demofinnhub.entity.BuyStock;

public interface BuyStockRepository extends JpaRepository<BuyStock, Long> {

}
