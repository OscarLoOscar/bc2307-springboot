package com.vtxlab.finnhubapi.service;

import java.util.List;
import com.vtxlab.finnhubapi.exception.FinnhubException;
import com.vtxlab.finnhubapi.model.dto.StockDTO;

public interface WebStockService {

  StockDTO stockInfo(String symbol) throws FinnhubException;


}
