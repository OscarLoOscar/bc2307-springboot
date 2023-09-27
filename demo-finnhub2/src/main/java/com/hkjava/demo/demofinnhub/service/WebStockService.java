package com.hkjava.demo.demofinnhub.service;

import java.util.List;
import com.hkjava.demo.demofinnhub.controller.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.dto.StockDTO;
import com.hkjava.demo.demofinnhub.model.dto.StockGetFromDBDTO;

public interface WebStockService {

  StockDTO stockInfo(String symbol) throws FinnhubException;

  List<StockGetFromDBDTO> stockInfo() throws FinnhubException;

  void addStock(Stock stock) throws FinnhubException;
}
