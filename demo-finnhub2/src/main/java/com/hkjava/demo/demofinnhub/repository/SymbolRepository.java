package com.hkjava.demo.demofinnhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hkjava.demo.demofinnhub.entity.StockSymbolEntity;

public interface SymbolRepository extends JpaRepository<StockSymbolEntity,Long>{
  
}
