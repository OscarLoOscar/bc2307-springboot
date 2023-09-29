package com.vtxlab.finnhubapi.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.finnhubapi.controller.SymbolOperation;
import com.vtxlab.finnhubapi.exception.FinnhubException;
import com.vtxlab.finnhubapi.infra.ApiResponse;
import com.vtxlab.finnhubapi.model.Symbol;
import com.vtxlab.finnhubapi.service.StockSymbolService;

@RestController
@RequestMapping(value = "/api/v1")
public class SymbolController implements SymbolOperation {

  @Autowired
  StockSymbolService stockSymbolService;

  @Override
  public ApiResponse<List<Symbol>> getStockSymbol() throws FinnhubException {
    // if (exchange.isBlank())
    // throw new IllegalArgumentException("Parameter Symbol is blank");
    return ApiResponse.<List<Symbol>>builder()//
        .ok()//
        .data(stockSymbolService.getStockSymbol())//
        .build();
  }

}
