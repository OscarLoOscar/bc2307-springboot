package com.hkjava.demo.demofinnhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hkjava.demo.demofinnhub.entity.SellStock;

public interface SellStockRepository extends JpaRepository<SellStock, Long> {

}
