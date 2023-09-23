package com.hkjava.demo.demofinnhub.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demofinnhub.controller.SymbolOperation;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;
import com.hkjava.demo.demofinnhub.model.Symbol;
import com.hkjava.demo.demofinnhub.service.callAPI.StockSymbolService;

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
