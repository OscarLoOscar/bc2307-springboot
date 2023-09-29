package com.example.demo.demostockexchange.services.impl;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.demostockexchange.entity.Customer;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.exception.FinnhubException;
import com.example.demo.demostockexchange.model.OrderRequest;
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
  public void processBuyStopOrder(OrderRequest orderRequest) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'createBuyStopOrder'");
  }

  @Override
  public void processSellStopOrder(OrderRequest orderRequest) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'processSellStopOrder'");
  }

  @Override
  public void processBuyLimitOrder(OrderRequest orderRequest) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'processBuyLimitOrder'");
  }

  @Override
  public void processSellLimitOrder(OrderRequest orderRequest) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'processSellLimitOrder'");
  }

  @Override
  public void processAskOrder(OrderRequest orderRequest) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'processAskOrder'");
  }

  @Override
  public void processBidOrder(OrderRequest orderRequest) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'processBidOrder'");
  }



  // private Queue<OrderRequest> buyOrders = new PriorityQueue<>(
  // (b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice())); // Descending order by price
  // private Queue<OrderRequest> sellOrders = new PriorityQueue<>(
  // (s1, s2) -> Double.compare(s1.getPrice(), s2.getPrice())); // Ascending order by price

  @Override
  public OrderRequest getBuyOrder() {
    Orders data = stockRepository.getBuyOrder("BUY");
    return finnhubMapper.mapSingleOrder(data);

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

