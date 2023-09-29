package com.vtxlab.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.admin.entity.StockSymbol;

@Repository
public interface SymbolRepository extends JpaRepository<StockSymbol,Long>{
  
}
