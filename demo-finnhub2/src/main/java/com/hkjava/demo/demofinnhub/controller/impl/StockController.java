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
import com.hkjava.demo.demofinnhub.infra.ApiResp;
import com.hkjava.demo.demofinnhub.model.dto.Request.SymbolReqDTO;
import com.hkjava.demo.demofinnhub.model.dto.Response.StockDTO;
import com.hkjava.demo.demofinnhub.model.dto.Response.StockGetFromDBDTO;
import com.hkjava.demo.demofinnhub.model.mapper.FinnhubMapper;
import com.hkjava.demo.demofinnhub.service.WebStockService;
import com.hkjava.demo.demofinnhub.service.impl.StockPriceServiceImpl;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class StockController implements StockOperation {

  @Autowired
  FinnhubMapper finnhubMapper;

  @Autowired
  WebStockService webStockService;

  @Autowired
  StockPriceServiceImpl stockServiceImpl;

  @Override
  public ApiResp<StockDTO> stockInfo(String symbol) // ""
      throws FinnhubException {
    if (symbol.isBlank())
      throw new IllegalArgumentException("Parameter Symbol is blank");

    return ApiResp.<StockDTO>builder() //
        .ok() //
        .data(webStockService.stockInfo(symbol)) //
        .build();
  }

  @Override
  public ApiResp<List<StockGetFromDBDTO>> stockInfoFromDb()
      throws FinnhubException {
    log.info("stockInfoFromDb : " + webStockService.stockInfo().toString());
    return ApiResp.<List<StockGetFromDBDTO>>builder()//
        .ok()//
        .data(webStockService.stockInfo())//
        .build();
  }

  @Override
  public ResponseEntity<Void> addStock(Stock stock) throws FinnhubException {
    webStockService.addStock(stock);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @Override
  public ApiResp<StockDTO> stockInfo2(SymbolReqDTO symbol)
      throws FinnhubException {
    return ApiResp.<StockDTO>builder() //
        .ok() //
        .data(webStockService.stockInfo(symbol.getSymbol())) //
        .build();
  }

}
