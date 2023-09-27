package com.example.demo.demostockexchange.model;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.demostockexchange.entity.Customer;
import com.example.demo.demostockexchange.entity.SellStock;
import com.hkjava.demo.demofinnhub.repository.BuyStockRepository;
import com.hkjava.demo.demofinnhub.repository.SellStockRepository;
import com.hkjava.demo.demofinnhub.service.OrderBookService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderBook {

  @Autowired
  OrderBookService orderBookService;

  // private Queue<BuyStock> buyOrders = new PriorityQueue<>(
  // (b1, b2) -> Float.compare(b2.getPrice(), b1.getPrice())); // Descending order by price
  // private Queue<SellStock> sellOrders = new PriorityQueue<>(
  // (s1, s2) -> Float.compare(s1.getPrice(), s2.getPrice())); // Ascending order by price

  public void addBuyOrder(Queue<Customer> buyOrder) {
    orderBookService.addBuyOrder(buyOrder);
  }

  public void addSellOrder(Queue<SellStock> sellOrder) {
    orderBookService.addSellOrder(sellOrder);
  }

  public void addBuyOrder(Customer buyOrder) {
    orderBookService.addBuyOrder(buyOrder);
  }

  public void addSellOrder(SellStock sellOrder) {
    orderBookService.addSellOrder(sellOrder);
  }

  // Implement methods to match and process orders
}
