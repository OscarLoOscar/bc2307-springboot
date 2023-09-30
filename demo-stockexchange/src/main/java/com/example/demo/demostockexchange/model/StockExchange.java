package com.example.demo.demostockexchange.model;

import java.util.PriorityQueue;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.model.mapper.FinnhubMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class StockExchange {

  private PriorityQueue<OrderResp> BidOrders; // Orders with highest bid price
  private PriorityQueue<OrderResp> AskOrders; // Orders with lowest ask price

}
