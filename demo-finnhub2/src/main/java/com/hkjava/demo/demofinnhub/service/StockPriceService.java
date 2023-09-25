package com.hkjava.demo.demofinnhub.service;

import java.util.List;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.model.Quote;

public interface StockPriceService {
  StockPrice getStockPriceById(Long id);

  List<StockPrice> getAllStockPrice();

}
