package com.hkjava.demo.demoshopping.service;

import java.time.LocalDate;
import java.util.Optional;
import com.hkjava.demo.demoshopping.model.Customer;

public interface CustomerService {
  
  Customer create(String name, String email, LocalDate dob);

  Optional<Customer> find(long customerId);
}
