package com.example.demo.demostockexchange.controller;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.demostockexchange.exception.ApiResponse;
import com.example.demo.demostockexchange.model.OrderRequest;
import com.example.demo.demostockexchange.model.mapper.FinnhubMapper;
import com.example.demo.demostockexchange.services.OrderBookService;

@RestController
@RequestMapping("/transactions")
public class WebSocketController implements WebSocketOperation {

  @Autowired
  private OrderBookService orderBookService;

  @Autowired
  private FinnhubMapper finnhubMapper;

  @Override
  public ApiResponse<List<OrderRequest>> updateOrderBook() {
    List<OrderRequest> response =
        finnhubMapper.map(orderBookService.getOrderBook());
    return ApiResponse.<List<OrderRequest>>builder()//
        .ok()//
        .data(response)//
        .build();
  }

  @Override
  public ApiResponse<Void> placeOrder(OrderRequest orderRequest) {
    orderBookService.addOrder(orderRequest);
    try {
      switch (orderRequest.getType()) {
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
              .message("Invalid order type: " + orderRequest).build();
      }
      return ApiResponse.<Void>builder()//
          .ok()//
          .message(orderRequest + " Order placed successfully.").build();
    } catch (Exception e) {
      // Handle exceptions
      return ApiResponse.<Void>builder()//
          .error()//
          .message("Failed to place order: " + e.getMessage()).build();
    }
  }

  public ApiResponse<Void> createBuyStopOrder(OrderRequest orderRequest) {
    // Validate and process the Buy Stop order request
    orderBookService.processBuyStopOrder(orderRequest);
    return ApiResponse.<Void>builder()//
        .ok()//
        .concatMessageIfPresent("Buy Stop Order created successfully.")//
        .build();
  }

  public ApiResponse<Void> createSellStopOrder(OrderRequest orderRequest) {
    // Validate and process the Sell Stop order request
    orderBookService.processSellStopOrder(orderRequest);
    return ApiResponse.<Void>builder()//
        .ok()//
        .concatMessageIfPresent("Sell Stop Order created successfully.")//
        .build();
  }

  public ApiResponse<Void> createBuyLimitOrder(OrderRequest orderRequest) {
    // Validate and process the Buy Limit order request
    orderBookService.processBuyLimitOrder(orderRequest);
    return ApiResponse.<Void>builder()//
        .ok()//
        .concatMessageIfPresent("Buy Limit Order created successfully.")//
        .build();
  }

  public ApiResponse<Void> createSellLimitOrder(OrderRequest orderRequest) {
    // Validate and process the Sell Limit order request
    orderBookService.processSellLimitOrder(orderRequest);
    return ApiResponse.<Void>builder()//
        .ok()//
        .concatMessageIfPresent("Sell Limit Order created successfully.")//
        .build();
  }


  public ApiResponse<Void> createAskOrder(OrderRequest orderRequest) {
    // Validate and process the Ask order request
    orderBookService.processAskOrder(orderRequest);
    return ApiResponse.<Void>builder()//
        .ok()//
        .concatMessageIfPresent("Ask Order created successfully.")//
        .build();
  }

  public ApiResponse<Void> createBidOrder(OrderRequest orderRequest) {
    // Validate and process the Bid order request
    orderBookService.processBidOrder(orderRequest);
    return ApiResponse.<Void>builder()//
        .ok()//
        .concatMessageIfPresent("Bid Order created successfully.")//
        .build();
  }

  @Override
  public ApiResponse<Queue<OrderRequest>> buyOrdersQueue() {
    Queue<OrderRequest> buyOrders = new PriorityQueue<>(
        (b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice())); // Descending order by price

    return orderBookService.getBuyOrder();
  }
}

