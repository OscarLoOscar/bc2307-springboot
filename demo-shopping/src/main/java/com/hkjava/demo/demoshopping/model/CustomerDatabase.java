package com.hkjava.demo.demoshopping.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDatabase {
  public static List<Customer> customers = new ArrayList<>();

  public static void add(Customer customer) {
    customers.add(customer);
  }

  public static Optional<Customer> find(long id) {
    return customers.stream() //
        .filter(customer -> customer.getId() == id) //
        .findFirst();
  }

  // public static void remove1(long id) {
  // customers.removeIf(e -> e.getId() == id);
  // }

  public static Customer remove(long id) {

    Optional<Customer> customer = CustomerDatabase.find(id);
    if (!customer.isPresent()) {
      return null;
    }
    CustomerDatabase.customers.remove(customer.get());
    return customer.get();
  }

  public static Customer update(long id, Customer newcustomer) {
    if (!find(id).isPresent())
      return null;
    CustomerDatabase.customers.stream()//
        .filter(e -> e.getId() == id)//
        .forEach(e -> {
          e.setId(id);
          e.setDob(newcustomer.getDob());
          e.setEmail(newcustomer.getEmail());
          e.setName(newcustomer.getName());
        });
    return newcustomer;
  }

  public static Customer patchEmail(long id, String email) {
    Optional<Customer> customer = find(id);
    if (!find(id).isPresent())
      return null;
    // customer.get().setEmail(email);
    customers.stream()//
        .filter(e -> e.getId() == id)//
        .forEach(e -> {
          // e.setDob(customer.get().getDob());
          e.setEmail(email);
          // e.setName(customer.get().getName());
        });
    return customer.get();
  }

  public static Customer patchName(long id, String name) {
    Optional<Customer> customer = find(id);
    if (!find(id).isPresent())
      return null;
    // customer.get().setEmail(email);
    customers.stream()//
        .filter(e -> e.getId() == id)//
        .forEach(e -> {
          // e.setDob(customer.get().getDob());
          // e.setEmail(customer.get().getEmail());
          e.setName(name);
        });
    return customer.get();
  }
}
