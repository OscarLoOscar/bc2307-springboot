package com.example.demo.demostockexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.demostockexchange.entity.Customer;

public interface BuyStockRepository extends JpaRepository<Customer, Long> {

}
