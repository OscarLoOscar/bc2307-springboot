package com.hkjava.demo.demoshopping.service;

import java.time.LocalDate;
import java.util.Optional;
import com.hkjava.demo.demoshopping.model.Customer;

public interface CustomerService {

  Customer create(String name, String email, LocalDate dob);

  Customer createCustomer(Customer customer);

  Optional<Customer> find(long customerId);

  Customer update(long customerId);

  Customer patchEmail(long customerId, String email);

  Customer patchName(long customerId, String name);

  void remove(long customerId);

}
