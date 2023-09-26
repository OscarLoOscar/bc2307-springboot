package com.example.demo.demostockexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.demostockexchange.entity.SellStock;

public interface SellStockRepository extends JpaRepository<SellStock, Long> {

}
