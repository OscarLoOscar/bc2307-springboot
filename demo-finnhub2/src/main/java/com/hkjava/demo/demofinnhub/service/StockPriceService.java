package com.hkjava.demo.demofinnhub.service;

import java.util.List;
import com.hkjava.demo.demofinnhub.entity.StockPrice;

public interface StockPriceService {
  StockPrice getStockPriceById(Long id);

  List<StockPrice> getAllStockPrice();

}
