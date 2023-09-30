package com.example.demo.demostockexchange.model.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.model.OrderRequest;

@Component
public class FinnhubMapper {

  @Autowired
  private ModelMapper modelMapper;

  public List<OrderRequest> map(List<Orders> ordersList) {
    return ordersList.stream()//
        .map(this::mapSingleOrder)//
        .collect(Collectors.toList());
  }

  public Queue<OrderRequest> convertListToQueue(List<Orders> ordersList) {
    Queue<OrderRequest> orderRequestQueue = new LinkedList<>();
    for (Orders order : ordersList) {
      OrderRequest orderRequest = mapSingleOrder(order);
      orderRequestQueue.add(orderRequest);
    }
    return orderRequestQueue;
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

  //
  public Orders requestToOrdersEntity(OrderRequest ordersRequest) {
    return Orders.builder() //
        .type(ordersRequest.getType())//
        .tradeDateTime(LocalDateTime.now())//
        .stockId(ordersRequest.getStockId())//
        .price(ordersRequest.getPrice())//
        .quantity(ordersRequest.getQuantity())//
        .build();
  }

}
