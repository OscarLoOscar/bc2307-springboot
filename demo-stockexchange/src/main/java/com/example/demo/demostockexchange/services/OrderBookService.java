package com.example.demo.demostockexchange.services;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.model.OrderRequest;
import com.example.demo.demostockexchange.model.OrderResp;
import com.example.demo.demostockexchange.model.StockExchange;

public interface OrderBookService {

  public PriorityQueue<OrderResp> getBidQueue(String stockId);

  public PriorityQueue<OrderResp> getAskQueue(String stockId);

  public List<Orders> getOrderBook();

  public void addOrder(OrderRequest makeOrder);

  public Map<String, StockExchange> atAuctionOrders(String stockId);
}

