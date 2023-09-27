package com.example.demo.demostockexchange.controller;

import java.lang.module.FindException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.infra.ApiResponse;

@RestController
@RequestMapping("/transactions")
public class WebSocketController implements WebSocketOperation {

  @Autowired
  private OrderService orderService;


  @Override
  public ApiResponse<List<Orders>> updateOrderBook() {
    return orderService.getOrderBook();
  }


  // @Override
  // public ApiResponse<Void> createBuyStopOrder(OrderRequest orderRequest) {
  // // Validate and process the Buy Stop order request
  // orderService.processBuyStopOrder(orderRequest);
  // return ApiResponse.<Void>builder().ok()
  // .concatMessageIfPresent("Buy Stop Order created successfully.").build();
  // }

  // @Override
  // public ApiResponse<Void> createSellStopOrder(OrderRequest orderRequest) {
  // // Validate and process the Sell Stop order request
  // orderService.processSellStopOrder(orderRequest);
  // return ApiResponse.<Void>builder().ok()
  // .concatMessageIfPresent("Sell Stop Order created successfully.")
  // .build();
  // }

  // @Override
  // public ApiResponse<Void> createBuyLimitOrder(OrderRequest orderRequest) {
  // // Validate and process the Buy Limit order request
  // orderService.processBuyLimitOrder(orderRequest);
  // return ApiResponse.<Void>builder().ok()
  // .concatMessageIfPresent("Buy Limit Order created successfully.")
  // .build();
  // }

  // @Override
  // public ApiResponse<Void> createSellLimitOrder(OrderRequest orderRequest) {
  // // Validate and process the Sell Limit order request
  // orderService.processSellLimitOrder(orderRequest);
  // return ApiResponse.<Void>builder().ok()
  // .concatMessageIfPresent("Sell Limit Order created successfully.")
  // .build();
  // }


  // @Override
  // public ApiResponse<Void> createAskOrder(OrderRequest orderRequest) {
  // // Validate and process the Ask order request
  // orderService.processAskOrder(orderRequest);
  // return ApiResponse.<Void>builder().ok()
  // .concatMessageIfPresent("Ask Order created successfully.").build();
  // }

  // @Override
  // public ApiResponse<Void> createBidOrder(OrderRequest orderRequest) {
  // // Validate and process the Bid order request
  // orderService.processBidOrder(orderRequest);
  // return ApiResponse.<Void>builder().ok()
  // .concatMessageIfPresent("Bid Order created successfully.").build();
  // }

  @Override
  public ApiResponse<Void> placeOrder(String orderType,
      OrderRequest orderRequest) {
    orderService.processOrder(orderType, orderRequest);
    try {
      switch (orderType) {
        case "buy-stop":
          createBuyStopOrder(orderRequest);
          break;
        case "sell-stop":
          createSellStopOrder(orderRequest);
          break;
        case "buy-limit":
          createBuyLimitOrder(orderRequest);
          break;
        case "sell-limit":
          createSellLimitOrder(orderRequest);
          break;
        case "ask":
          createAskOrder(orderRequest);
          break;
        case "bid":
          createBidOrder(orderRequest);
          break;
        default:
          return ApiResponse.<Void>builder()//
              .error()//
              .message("Invalid order type: " + orderType).build();
      }
      return ApiResponse.<Void>builder()//
          .ok()//
          .message(orderType + " Order placed successfully.").build();
    } catch (Exception e) {
      // Handle exceptions
      return ApiResponse.<Void>builder()//
          .error()//
          .message("Failed to place order: " + e.getMessage()).build();
    }
  }
}

