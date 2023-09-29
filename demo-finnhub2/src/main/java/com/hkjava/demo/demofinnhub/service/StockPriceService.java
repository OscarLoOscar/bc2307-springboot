package com.hkjava.demo.demofinnhub.service;

import java.util.List;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.APImodel.Quote;

public interface StockPriceService {
  Quote getQuote(String symbol) throws FinnhubException;

  StockPrice save(Long id, StockPrice stockprice);

  List<StockPrice> getAllPrice(Long stockId);
}

