package com.vtxlab.finnhubapi.service;

import java.util.List;
import com.vtxlab.finnhubapi.exception.FinnhubException;
import com.vtxlab.finnhubapi.model.Symbol;

public interface StockSymbolService {
  List<Symbol> getStockSymbol() throws FinnhubException;


}
