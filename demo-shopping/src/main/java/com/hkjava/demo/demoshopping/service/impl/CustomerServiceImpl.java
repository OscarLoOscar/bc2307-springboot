package com.hkjava.demo.demoshopping.service.impl;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.hkjava.demo.demoshopping.model.Customer;
import com.hkjava.demo.demoshopping.model.CustomerDatabase;
import com.hkjava.demo.demoshopping.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
  
  @Override
  public Customer create(String name, String email, LocalDate dob) {
    Customer customer = Customer.builder() //
      .name(name)
      .email(email)
      .dob(dob)
      .build();
    CustomerDatabase.add(customer);
    return customer;
  }


  @Override
  public Optional<Customer> find(long customerId) {
    return CustomerDatabase.find(customerId);
  }

}
