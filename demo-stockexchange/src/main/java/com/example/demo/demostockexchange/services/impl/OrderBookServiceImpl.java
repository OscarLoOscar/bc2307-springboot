package com.example.demo.demostockexchange.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.infra.tradeType;
import com.example.demo.demostockexchange.model.OrderRequest;
import com.example.demo.demostockexchange.model.OrderResp;
import com.example.demo.demostockexchange.model.StockExchange;
import com.example.demo.demostockexchange.model.mapper.FinnhubMapper;
import com.example.demo.demostockexchange.repository.StockRepository;
import com.example.demo.demostockexchange.services.OrderBookService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderBookServiceImpl implements OrderBookService {

  @Autowired
  FinnhubMapper finnhubMapper;

  @Autowired
  StockRepository stockRepository;

  @Override
  public List<Orders> getOrderBook() {
    return stockRepository.findAll();
  }

  @Override
  public void addOrder(OrderRequest makeOrder) {
    Orders response = finnhubMapper.requestToOrdersEntity(makeOrder);
    stockRepository.save(response);
  }

  @Override
  public PriorityQueue<OrderResp> getBidQueue() {
    List<Orders> data = this.getOrderBook();
    List<Orders> response = new ArrayList<>();
    for (Orders order : data) {
      if (tradeType.BID.name().toLowerCase()
          .equals(order.getType().toLowerCase())) {
        response.add(order);
      }
    } // Queue<OrderRequest> buyOrders = new PriorityQueue<>(
      // (b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice())); // Descending order by price
    return finnhubMapper.convertListToQueue(response);

  }

  @Override
  public Map<String, PriorityQueue<OrderResp>> separateOrders(String stockId) {
    Map<String, PriorityQueue<OrderResp>> separatedOrders = new HashMap<>();
    PriorityQueue<OrderResp> newQueue = new PriorityQueue<>((o1, o2) -> {
      int priceComparison = Double.compare(o2.getPrice(), o1.getPrice());
      if (priceComparison != 0) {
        // If prices are different, prioritize by price
        return priceComparison;
      } else {
        // If prices are equal, prioritize by timestamp (tradeDateTime)
        return o2.getQuantity().compareTo(o1.getQuantity());
      }
    });
    for (OrderResp order : this.getBidQueue()) {
      if (order.getStockId().equals(stockId)) {
        newQueue.add(order);
      }
      separatedOrders.put(stockId, newQueue);
    }
    return separatedOrders;
  }
}


