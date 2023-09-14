package com.hkjava.demo.demoshopping.model;

import java.util.ArrayList;
import java.util.List;

public class CartDatabase {
  public static List<Cart> carts = new ArrayList<>();

  /**
   * remove cart by customer id from List<Cart>
   * 
   * @param customerId
   */
  public static void remove(int customerId) {

  }

  public static void add(Cart cart) {
    carts.add(cart);
  }
}
