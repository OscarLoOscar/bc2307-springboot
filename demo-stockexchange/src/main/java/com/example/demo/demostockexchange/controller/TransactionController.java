package com.hkjava.demo.demofinnhub.controller.impl;

import java.lang.module.FindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demofinnhub.controller.TransactionOperation;
import com.hkjava.demo.demofinnhub.entity.BuyStock;
import com.hkjava.demo.demofinnhub.entity.SellStock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;
import com.hkjava.demo.demofinnhub.model.MakeTradeManager;
import com.hkjava.demo.demofinnhub.model.OrderBook;
import com.hkjava.demo.demofinnhub.service.OrderBookService;

@RestController
@RequestMapping("/transactions")
public class TransactionController implements TransactionOperation {
  @Autowired
  private OrderBook orderBook;

  @Autowired
  private OrderBookService orderBookService;

  @Override
  public ApiResponse<Void> buyStock(BuyStock buyStock) {
    orderBook.addBuyOrder(buyStock);
    return ApiResponse.<Void>builder()//
        .ok()//
        .concatMessageIfPresent("Buy Order Done") //
        .build();

  }

  @Override
  public ApiResponse<Void> sellStock(SellStock sellStock) {
    orderBook.addSellOrder(sellStock);
    return ApiResponse.<Void>builder()//
        .ok()//
        .concatMessageIfPresent("Sell Order Done") //
        .build();
  }

  @Override
  public ApiResponse<MakeTradeManager> checkStock(String symbol)
      throws FinnhubException {
    if (symbol == null)
      throw new FindException("Input cannot be null");

    MakeTradeManager response = orderBookService.getBidAskPriceBySymbol(symbol);

    return ApiResponse.<MakeTradeManager>builder()//
        .ok()//
        .data(response)//
        .build();


  }

}
