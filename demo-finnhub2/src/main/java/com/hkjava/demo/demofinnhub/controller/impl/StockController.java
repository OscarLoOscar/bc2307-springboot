package com.hkjava.demo.demofinnhub.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demofinnhub.controller.StockOperation;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;
import com.hkjava.demo.demofinnhub.model.dto.StockDTO;
import com.hkjava.demo.demofinnhub.model.dto.StockGetFromDBDTO;
import com.hkjava.demo.demofinnhub.service.callAPI.WebStockService;
import com.hkjava.demo.demofinnhub.service.callAPI.impl.StockServiceImpl;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class StockController implements StockOperation {

  @Autowired
  WebStockService webStockService;

  @Autowired
  StockServiceImpl stockServiceImpl;

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

  @Override
  public ApiResponse<List<StockGetFromDBDTO>> stockInfoFromDb()
      throws FinnhubException {
    log.info("stockInfoFromDb : " + webStockService.stockInfo().toString());
    return ApiResponse.<List<StockGetFromDBDTO>>builder()//
        .ok()//
        .data(webStockService.stockInfo())//
        .build();
  }

  @Override
  public ResponseEntity<Void> addStock(Stock stock) throws FinnhubException {
    webStockService.addStock(stock);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
