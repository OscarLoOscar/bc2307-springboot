package com.example.demo.demostockexchange.services;

import java.util.Queue;
import com.example.demo.demostockexchange.entity.Customer;
import com.example.demo.demostockexchange.entity.SellStock;
import com.example.demo.demostockexchange.model.MakeTradeManager;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;

public interface OrderBookService {
  MakeTradeManager getBidAskPriceBySymbol(String symbol)
      throws FinnhubException;

  public void addBuyOrder(Queue<Customer> buyOrder);

  public void addSellOrder(Queue<SellStock> sellOrder);

  public void addBuyOrder(Customer buyOrder);

  public void addSellOrder(SellStock sellOrder);
}

