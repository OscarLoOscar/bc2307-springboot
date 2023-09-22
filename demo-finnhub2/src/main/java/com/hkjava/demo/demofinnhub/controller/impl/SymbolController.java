package com.hkjava.demo.demofinnhub.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demofinnhub.controller.SymbolOperation;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;
import com.hkjava.demo.demofinnhub.model.StockSymbol;
import com.hkjava.demo.demofinnhub.service.SymbolService;

@RestController
@RequestMapping(value = "/api/v1")
public class SymbolController implements SymbolOperation {

  @Autowired
  SymbolService symbolservice;

  @Override
  public ApiResponse<List<StockSymbol>> getStockSymbol(String exchange)
      throws FinnhubException {
    if (exchange.isBlank())
      throw new IllegalArgumentException("Parameter Symbol is blank");
    return ApiResponse.<List<StockSymbol>>builder()//
        .ok()//
        .data(symbolservice.getStockSymbol(exchange))//
        .build();
  }

}
