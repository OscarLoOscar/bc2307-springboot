package com.hkjava.demo.demofinnhub.service;

import java.util.List;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.StockSymbol;

public interface SymbolService {
  List<StockSymbol> getStockSymbol(String exange) throws FinnhubException;
}
