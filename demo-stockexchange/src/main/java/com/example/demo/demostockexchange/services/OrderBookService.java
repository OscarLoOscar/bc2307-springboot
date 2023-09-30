package com.example.demo.demostockexchange.services;

import java.util.List;
import java.util.Queue;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.demostockexchange.entity.Customer;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.exception.ApiResponse;
import com.example.demo.demostockexchange.exception.FinnhubException;
import com.example.demo.demostockexchange.model.OrderRequest;

public interface OrderBookService {

  public Queue<OrderRequest> getBuyOrder();

  public List<Orders> getOrderBook();

  public void addOrder(OrderRequest makeOrder);

  public void processAskOrder(OrderRequest orderRequest);

  public void processBidOrder(OrderRequest orderRequest);
}

