package com.example.demo.demostockexchange.controller;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.exception.ApiResponse;
import com.example.demo.demostockexchange.exception.FinnhubException;
import com.example.demo.demostockexchange.infra.Code;
import com.example.demo.demostockexchange.infra.tradeType;
import com.example.demo.demostockexchange.model.OrderRequest;
import com.example.demo.demostockexchange.model.mapper.FinnhubMapper;
import com.example.demo.demostockexchange.services.OrderBookService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
  public ApiResponse<Orders> placeOrder(OrderRequest orderRequest)
      throws FinnhubException {
    if (tradeType.ASK.name().equals(orderRequest.getType().toUpperCase())) {
      createAskOrder(orderRequest);
    } else if (tradeType.BID.name()
        .equals(orderRequest.getType().toUpperCase())) {
      createBidOrder(orderRequest);
    }
    return ApiResponse.<Orders>builder()//
        .ok()//
        .message(orderRequest.getType().toUpperCase()
            + " Order placed successfully.")//
            .data(finnhubMapper.requestToOrdersEntity(orderRequest))//
        .build();
  }

  public void createAskOrder(OrderRequest orderRequest) {
    // Validate and process the Ask order request
    orderBookService.addOrder(orderRequest);
  }

  public void createBidOrder(OrderRequest orderRequest) {
    // Validate and process the Bid order request
    orderBookService.addOrder(orderRequest);
  }

  @Override
  public ApiResponse<Queue<OrderRequest>> buyOrdersQueue() {
    // Queue<OrderRequest> buyOrders = new PriorityQueue<>(
    // (b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice())); // Descending order by price
    // buyOrders.add(orderBookService.getBuyOrder());
    Queue<OrderRequest> buyOrders = orderBookService.getBuyOrder();
    return ApiResponse.<Queue<OrderRequest>>builder()//
        .ok()//
        .data(buyOrders)//
        .build();
  }

  // public ApiResponse<Void> createBuyStopOrder(OrderRequest orderRequest) {
  // // Validate and process the Buy Stop order request
  // orderBookService.processBuyStopOrder(orderRequest);
  // return ApiResponse.<Void>builder()//
  // .ok()//
  // .concatMessageIfPresent("Buy Stop Order created successfully.")//
  // .build();
  // }

  // public ApiResponse<Void> createSellStopOrder(OrderRequest orderRequest) {
  // // Validate and process the Sell Stop order request
  // orderBookService.processSellStopOrder(orderRequest);
  // return ApiResponse.<Void>builder()//
  // .ok()//
  // .concatMessageIfPresent("Sell Stop Order created successfully.")//
  // .build();
  // }

  // public ApiResponse<Void> createBuyLimitOrder(OrderRequest orderRequest) {
  // // Validate and process the Buy Limit order request
  // orderBookService.processBuyLimitOrder(orderRequest);
  // return ApiResponse.<Void>builder()//
  // .ok()//
  // .concatMessageIfPresent("Buy Limit Order created successfully.")//
  // .build();
  // }

  // public ApiResponse<Void> createSellLimitOrder(OrderRequest orderRequest) {
  // // Validate and process the Sell Limit order request
  // orderBookService.processSellLimitOrder(orderRequest);
  // return ApiResponse.<Void>builder()//
  // .ok()//
  // .concatMessageIfPresent("Sell Limit Order created successfully.")//
  // .build();
  // }
}

