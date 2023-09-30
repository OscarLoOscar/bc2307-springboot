package com.example.demo.demostockexchange.model;

import java.util.PriorityQueue;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.model.mapper.FinnhubMapper;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StockExchange {

  @Autowired
  FinnhubMapper finnhubMapper;

  private PriorityQueue<OrderResp> buyOrders; // Orders with highest bid price
  private PriorityQueue<OrderResp> sellOrders; // Orders with lowest ask price

  public StockExchange() {
    // Initialize the PriorityQueues with appropriate comparators
    buyOrders = new PriorityQueue<>(
        (o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
    sellOrders = new PriorityQueue<>(
        (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
  }

  public void placeOrder(Orders order) {
    OrderResp response = finnhubMapper.mapSingleOrderToOrderResp(order);
    if ("Bid".equals(order.getType())) {
      buyOrders.offer(response);
    } else if ("ASK".equals(order.getType())) {
      sellOrders.offer(response);
    }
  }
}
