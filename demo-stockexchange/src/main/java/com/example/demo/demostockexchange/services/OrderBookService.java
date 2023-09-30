package com.example.demo.demostockexchange.services;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.demostockexchange.entity.Customer;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.exception.ApiResponse;
import com.example.demo.demostockexchange.exception.FinnhubException;
import com.example.demo.demostockexchange.model.OrderRequest;
import com.example.demo.demostockexchange.model.OrderResp;
import com.example.demo.demostockexchange.model.StockExchange;

public interface OrderBookService {

  public PriorityQueue<OrderResp> getBidQueue();

  public List<Orders> getOrderBook();

  public void addOrder(OrderRequest makeOrder);

}

