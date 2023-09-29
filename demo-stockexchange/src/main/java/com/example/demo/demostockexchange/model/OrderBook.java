// package com.example.demo.demostockexchange.model;

// import java.util.Deque;
// import java.util.PriorityQueue;
// import java.util.Queue;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import com.example.demo.demostockexchange.entity.Customer;
// import com.example.demo.demostockexchange.entity.Orders;
// import com.example.demo.demostockexchange.services.OrderBookService;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;

// @Component
// @Getter
// @Setter
// @AllArgsConstructor
// @NoArgsConstructor
// @ToString
// public class OrderBook {

//   @Autowired
//   OrderBookService orderBookService;

//   // private Queue<Orders> buyOrders = new PriorityQueue<>(
//   // (b1, b2) -> Float.compare(b2.getPrice(), b1.getPrice())); // Descending order by price
//   // private Queue<Orders> sellOrders = new PriorityQueue<>(
//   // (s1, s2) -> Float.compare(s1.getPrice(), s2.getPrice())); // Ascending order by price


//   public void addBuyOrder(Orders buyOrder) {
//     orderBookService.addOrder(buyOrder);
//   }

//   public void addSellOrder(Orders sellOrder) {
//     orderBookService.addOrder(sellOrder);
//   }

//   // Implement methods to match and process orders
// }
