package com.hkjava.demo.demoshopping.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDatabase {
  private static List<Customer> customers = new ArrayList<>();

  public static void add(Customer customer) {
    customers.add(customer);
  }

  public static Optional<Customer> find(long id) {
    return customers.stream() //
        .filter(customer -> customer.getId() == id) //
        .findFirst();
  }
}
