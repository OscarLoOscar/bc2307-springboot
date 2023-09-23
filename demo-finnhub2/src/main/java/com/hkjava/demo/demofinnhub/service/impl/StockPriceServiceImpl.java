package com.hkjava.demo.demofinnhub.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.repository.StockPriceRepository;
import com.hkjava.demo.demofinnhub.service.StockPriceService;

@Service
public class StockPriceServiceImpl implements StockPriceService {
  
  @Autowired
  private StockPriceRepository stockPriceRepository;

  public StockPrice getStockPriceById(Long id) {
    return stockPriceRepository.findById(id).orElse(null);
  }

  @Override
  public List<StockPrice> getAllStockPrice() {
    return stockPriceRepository.findAll();
  }

}
