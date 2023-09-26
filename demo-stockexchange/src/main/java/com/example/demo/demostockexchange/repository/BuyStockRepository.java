package com.example.demo.demostockexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.demostockexchange.entity.BuyStock;

public interface BuyStockRepository extends JpaRepository<BuyStock, Long> {

}
