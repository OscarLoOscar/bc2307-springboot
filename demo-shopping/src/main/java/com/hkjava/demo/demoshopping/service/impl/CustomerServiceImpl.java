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
        .name(name)//
        .email(email)//
        .dob(dob)//
        .build();
    CustomerDatabase.add(customer);
    return customer;
  }


  @Override
  public Optional<Customer> find(long customerId) {
    return CustomerDatabase.find(customerId);
  }


  @Override
  public void remove(long customerId) {
    CustomerDatabase.remove(customerId);
  }


  @Override
  public Customer createCustomer(Customer customer) {
    CustomerDatabase.add(customer);
    return customer;
  }


  @Override
  public Customer update(long customerId) {
    Optional<Customer> customerToUpdate = CustomerDatabase.find((customerId));

    return CustomerDatabase.update(customerId, null); // <-"Cannot invoke \"com.hkjava.demo.demoshopping.model.Customer.getDob()\" because \"<parameter1>\" is null",
  }

  // gpt code
  @Override
  public Customer patchEmail(long customerId, String email) {
    return CustomerDatabase.patchEmail(customerId, email);
  }

  // gpt code
  @Override
  public Customer patchName(long customerId, String name) {
    return CustomerDatabase.patchName(customerId, name);
  }

}
