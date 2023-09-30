package com.example.demo.demostockexchange.services.impl;

import java.util.ArrayList;
import java.util.List;
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

  // private Queue<OrderRequest> buyOrders = new PriorityQueue<>(
  // (b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice())); // Descending order by price
  // private Queue<OrderRequest> sellOrders = new PriorityQueue<>(
  // (s1, s2) -> Double.compare(s1.getPrice(), s2.getPrice())); // Ascending order by price

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
}


// @Override
// public MakeTradeManager getBidAskPriceBySymbol(String symbol)
// throws FinnhubException {
// if (symbol.isEmpty())
// return null;

// for (Customer i : buyStockRepository.findAll()) {
// buyOrders.add(i);
// }
// for (SellStock i : sellStockRepository.findAll()) {
// sellOrders.add(i);
// }

// OrderBook orderBook = new OrderBook();
// orderBook.addBuyOrder(buyOrders);
// log.info("service orderBook BUY : " + orderBook);
// orderBook.addSellOrder(sellOrders);
// log.info("service orderBook SELL : " + orderBook);

// return new MakeTradeManager(symbol, orderBook);
// }

