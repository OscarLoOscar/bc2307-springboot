package com.hkjava.demo.demofinnhub.service;

import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.Quote;

public interface StockService {

  Quote getQuote(String symbol) throws FinnhubException;
  
}
