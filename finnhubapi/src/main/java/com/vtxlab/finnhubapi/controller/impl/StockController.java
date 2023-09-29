package com.vtxlab.finnhubapi.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.finnhubapi.controller.StockOperation;
import com.vtxlab.finnhubapi.exception.FinnhubException;
import com.vtxlab.finnhubapi.infra.ApiResponse;
import com.vtxlab.finnhubapi.model.dto.StockDTO;
import com.vtxlab.finnhubapi.service.WebStockService;
import com.vtxlab.finnhubapi.service.impl.StockPriceServiceImpl;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class StockController implements StockOperation {

  @Autowired
  WebStockService webStockService;

  @Autowired
  StockPriceServiceImpl stockServiceImpl;

  @Override
  public ApiResponse<StockDTO> stockInfo(String symbol) // ""
      throws FinnhubException {
    if (symbol.isBlank())
      throw new IllegalArgumentException("Parameter Symbol is blank");

    return ApiResponse.<StockDTO>builder() //
        .ok() //
        .data(webStockService.stockInfo(symbol)) //
        .build();
  }
}
