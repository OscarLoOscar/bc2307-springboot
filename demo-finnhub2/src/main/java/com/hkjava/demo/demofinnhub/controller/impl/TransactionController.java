package com.hkjava.demo.demofinnhub.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demofinnhub.controller.TransactionOperation;
import com.hkjava.demo.demofinnhub.entity.BuyStock;
import com.hkjava.demo.demofinnhub.entity.SellStock;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;
import com.hkjava.demo.demofinnhub.model.OrderBook;

@RestController
@RequestMapping("/transactions")
public class TransactionController implements TransactionOperation {
  @Autowired
  private OrderBook orderBook;

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

}
