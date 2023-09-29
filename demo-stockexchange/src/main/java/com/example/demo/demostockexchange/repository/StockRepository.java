package com.example.demo.demostockexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.demostockexchange.entity.Orders;

public interface StockRepository extends JpaRepository<Orders, Long> {
  @Query("SELECT s.type from Orders s WHERE type = 'BUY' ")
  Orders getBuyOrder(String type);


}
