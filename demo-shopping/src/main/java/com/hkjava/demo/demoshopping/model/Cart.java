package com.hkjava.demo.demoshopping.model;

public class Cart {// 借黎做DB
  private long id;// primary key
  private Customer customer; // customer id
  private Order order; // List<Item>
  // Question : Customer入面有List<Orders>，有冇問題？-> 冇

  public void add() {

  }

  public void remove() {
    
  }
}
