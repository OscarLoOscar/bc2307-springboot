package com.example.demo.demostockexchange.model.mapper;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.infra.tradeType;
import com.example.demo.demostockexchange.model.OrderRequest;
import com.example.demo.demostockexchange.model.OrderResp;
import com.example.demo.demostockexchange.model.StockExchange;

@Component
public class FinnhubMapper {

  @Autowired
  private ModelMapper modelMapper;


  public List<OrderRequest> map(List<Orders> ordersList) {
    return ordersList.stream()//
        .map(this::mapSingleOrder)//
        .collect(Collectors.toList());
  }

  public OrderRequest mapSingleOrder(Orders orders) {
    return OrderRequest.builder() //
        .type(orders.getType())//
        // .tradeDate(orders.getTradeDate())//
        .stockId(orders.getStockId())//
        .price(orders.getPrice())//
        .quantity(orders.getQuantity())//
        .build();
  }
  // ---------------

  public PriorityQueue<OrderResp> convertListToQueue(List<Orders> ordersList) {
    PriorityQueue<OrderResp> orderRequestQueue =
        new PriorityQueue<>((o1, o2) -> {
          int priceComparison = Double.compare(o2.getPrice(), o1.getPrice());
          if (priceComparison != 0) {
            // If prices are different, prioritize by price
            return priceComparison;
          } else {
            // If prices are equal, prioritize by timestamp (tradeDateTime)
            return o1.getQuantity().compareTo(o2.getQuantity());
          }
        });

    for (Orders order : ordersList) {
      OrderResp output = this.mapSingleOrderToOrderResp(order);
      orderRequestQueue.add(output);
    }
    return orderRequestQueue;
  }

  public OrderResp mapSingleOrderToOrderResp(Orders orders) {
    return OrderResp.builder() //
        // .type(orders.getType())//
        // .tradeDate(orders.getTradeDate())//
        // .stockId(orders.getStockId())//
        .price(orders.getPrice())//
        .quantity(orders.getQuantity())//
        .build();
  }

  // -------------------
  public Orders requestToOrdersEntity(OrderRequest ordersRequest) {
    return Orders.builder() //
        .type(ordersRequest.getType())//
        .tradeDateTime(LocalDateTime.now())//
        .stockId(ordersRequest.getStockId())//
        .price(ordersRequest.getPrice())//
        .quantity(ordersRequest.getQuantity())//
        .build();
  }

  // --------
  public StockExchange installBidQueueAndAskQueue(PriorityQueue<OrderResp> Bid,
      PriorityQueue<OrderResp> Ask) {
    return StockExchange.builder()//
        .BidOrders(Bid)//
        .AskOrders(Ask)//
        .build();
  }
}
