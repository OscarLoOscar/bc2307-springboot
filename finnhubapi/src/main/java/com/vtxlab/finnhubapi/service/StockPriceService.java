package com.vtxlab.finnhubapi.service;

import java.util.List;
import com.vtxlab.finnhubapi.exception.FinnhubException;
import com.vtxlab.finnhubapi.model.Quote;

public interface StockPriceService {
  Quote getQuote(String symbol) throws FinnhubException;

}
