package com.hkjava.demo.demofinnhub.service.impl;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.demostockexchange.entity.BuyStock;
import com.example.demo.demostockexchange.entity.SellStock;
import com.example.demo.demostockexchange.model.MakeTradeManager;
import com.example.demo.demostockexchange.model.OrderBook;
import com.example.demo.demostockexchange.repository.BuyStockRepository;
import com.example.demo.demostockexchange.repository.SellStockRepository;
import com.example.demo.demostockexchange.services.OrderBookService;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.repository.SymbolRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderBookServiceImpl implements OrderBookService {

  @Autowired
  BuyStockRepository buyStockRepository;

  @Autowired
  SellStockRepository sellStockRepository;

  @Autowired
  SymbolRepository symbolRepository;

  @Autowired
  Queue<BuyStock> buyOrders;

  @Autowired
  Queue<SellStock> sellOrders;
  // private Queue<BuyStock> buyOrders = new PriorityQueue<>(
  // (b1, b2) -> Float.compare(b2.getPrice(), b1.getPrice())); // Descending order by price
  // private Queue<SellStock> sellOrders = new PriorityQueue<>(
  // (s1, s2) -> Float.compare(s1.getPrice(), s2.getPrice())); // Ascending order by price


  @Override
  public MakeTradeManager getBidAskPriceBySymbol(String symbol)
      throws FinnhubException {
    if (symbol.isEmpty())
      return null;

    for (BuyStock i : buyStockRepository.findAll()) {
      buyOrders.add(i);
    }
    for (SellStock i : sellStockRepository.findAll()) {
      sellOrders.add(i);
    }

    OrderBook orderBook = new OrderBook();
    orderBook.addBuyOrder(buyOrders);
    log.info("service orderBook BUY : " + orderBook);
    orderBook.addSellOrder(sellOrders);
    log.info("service orderBook SELL : " + orderBook);

    return new MakeTradeManager(symbol, orderBook);
  }


  @Override
  public void addBuyOrder(Queue<BuyStock> buyOrder) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addBuyOrder'");
  }


  @Override
  public void addSellOrder(Queue<SellStock> sellOrder) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addSellOrder'");
  }


  @Override
  public void addBuyOrder(BuyStock buyOrder) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addBuyOrder'");
  }


  @Override
  public void addSellOrder(SellStock sellOrder) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addSellOrder'");
  }


  // @Override
  // public void addBuyOrder(Queue<BuyStock> buyOrder) {
  // buyOrders.add(buyOrder);
  // buyStockRepository.save(buyOrder);
  // }


  // @Override
  // public void addSellOrder(Queue<SellStock> sellOrder) {
  // sellOrders.add(sellOrder);
  // sellStockRepository.save(sellOrder);
  // }


}
