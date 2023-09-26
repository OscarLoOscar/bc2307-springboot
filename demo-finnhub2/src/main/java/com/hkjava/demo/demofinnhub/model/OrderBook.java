package com.hkjava.demo.demofinnhub.model;

import java.util.PriorityQueue;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.hkjava.demo.demofinnhub.entity.BuyStock;
import com.hkjava.demo.demofinnhub.entity.SellStock;
import com.hkjava.demo.demofinnhub.repository.BuyStockRepository;
import com.hkjava.demo.demofinnhub.repository.SellStockRepository;

@Component
public class OrderBook {
  @Autowired
  BuyStockRepository buyStockRepository;

  @Autowired
  SellStockRepository sellStockRepository;

  private Queue<BuyStock> buyOrders = new PriorityQueue<>(
      (b1, b2) -> Float.compare(b2.getPrice(), b1.getPrice())); // Descending order by price
  private Queue<SellStock> sellOrders = new PriorityQueue<>(
      (s1, s2) -> Float.compare(s1.getPrice(), s2.getPrice())); // Ascending order by price

  public void addBuyOrder(BuyStock buyOrder) {
    buyOrders.add(buyOrder);
    buyStockRepository.save(buyOrder);
    // Implement logic to match buy and sell orders here
  }

  public void addSellOrder(SellStock sellOrder) {
    sellOrders.add(sellOrder);
    sellStockRepository.save(sellOrder);
    // Implement logic to match buy and sell orders here
  }

  // Implement methods to match and process orders
}
