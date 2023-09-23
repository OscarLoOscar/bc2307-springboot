package com.hkjava.demo.demofinnhub.service.callAPI;

import java.util.List;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.Quote;

public interface StockService {

  Quote getQuote(String symbol) throws FinnhubException;

  Stock getStockById(Long id);

  List<Stock> getStock();

}

