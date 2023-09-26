package com.example.demo.demostockexchange.model;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MakeTradeManager {
  private String stockSymbol;
  private OrderBook orderBook;

  public MakeTradeManager(String stockSymbol, OrderBook orderBook) {
    Map<String, OrderBook> orderBookMap = new HashMap<>();
    orderBookMap.put(this.stockSymbol, this.orderBook);

  }
}
