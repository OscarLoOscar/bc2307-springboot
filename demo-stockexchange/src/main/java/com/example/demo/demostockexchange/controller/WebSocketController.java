package com.example.demo.demostockexchange.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.demostockexchange.annotation.SymbolCheck;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.exception.ApiResponse;
import com.example.demo.demostockexchange.exception.FinnhubException;
import com.example.demo.demostockexchange.infra.Code;
import com.example.demo.demostockexchange.infra.tradeType;
import com.example.demo.demostockexchange.model.OrderRequest;
import com.example.demo.demostockexchange.model.OrderResp;
import com.example.demo.demostockexchange.model.StockExchange;
import com.example.demo.demostockexchange.model.mapper.FinnhubMapper;
import com.example.demo.demostockexchange.services.OrderBookService;
import lombok.extern.slf4j.Slf4j;

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

  List<String> tradeStock = List.of("AAPL", "TSLA", "MSFT");

  @Override
  public ApiResponse<Orders> placeOrder(OrderRequest orderRequest)
      throws FinnhubException {

    // List<String> tradeStock = List.of("AAPL", "TSLA", "MSFT");
    if (!tradeStock.contains(orderRequest.getStockId()))
      throw new FinnhubException(Code.FINNHUB_SYMBOL_NOTFOUND);
    if (tradeType.ASK.name().equals(orderRequest.getType().toUpperCase())
        && tradeStock.contains(orderRequest.getStockId())) {
      createAskOrder(orderRequest);
    } else if (tradeType.BID.name().equals(orderRequest.getType().toUpperCase())
        && tradeStock.contains(orderRequest.getStockId())) {
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
  public ApiResponse<PriorityQueue<OrderResp>> BidOrdersQueue(String stockId) {
    PriorityQueue<OrderResp> orderQueue = orderBookService.getBidQueue(stockId);
    return ApiResponse.<PriorityQueue<OrderResp>>builder()//
        .ok()//
        .data(orderQueue)//
        .build();
  }

  @Override
  public ApiResponse<PriorityQueue<OrderResp>> AskOrdersQueue(String stockId) {
    PriorityQueue<OrderResp> orderQueue = orderBookService.getAskQueue(stockId);
    return ApiResponse.<PriorityQueue<OrderResp>>builder()//
        .ok()//
        .data(orderQueue)//
        .build();
  }

  @Override
  public Map<String, StockExchange> atAuctionOrders(String stockId)
      throws FinnhubException {
    if (!tradeStock.contains(stockId)) {
      throw new FinnhubException(Code.NOTFOUND);
    }
    return orderBookService.atAuctionOrders(stockId);
  }


}

