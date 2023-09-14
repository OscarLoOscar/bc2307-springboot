package com.hkjava.demo.demoshopping.controller.impl;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demoshopping.controller.CustomerOperation;
import com.hkjava.demo.demoshopping.model.Customer;
import com.hkjava.demo.demoshopping.service.CustomerService;

@RestController
@RequestMapping(value = "/api/v1")
public class CustomerController implements CustomerOperation {

  @Autowired
  CustomerService customerService;

  @Override
  public Customer create(String name, String email, LocalDate dob) {
    return customerService.create(name, email, dob);
  }

  @Override
  public Customer find(String customerId) {
    if (!customerId.isBlank()) {
      try {
        long id = Integer.valueOf(customerId);
        return customerService.find(id).orElse(null);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }

  @Override
  public Customer remove(String customerId) {
    // Optional<Customer> customer = find(customerId);
    if (!customerId.isBlank()) {
      try {
        long id = Integer.valueOf(customerId);
        customerService.remove(id);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }

  @Override
  public Customer createCustomer(Customer customer) {
    return customerService.createCustomer(customer);
  }

  // not finish , "message": "Required path variable 'customerId' is not present.",
  @Override
  public Customer update(String customerId, Customer customer) {
    if (!customerId.isBlank()) {
      try {
        long id = Integer.valueOf(customerId);
        customerService.update(id);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }

  @Override
  public Customer patchEmail(String id, String email) {
    if (!id.isBlank()) {
      try {
        long customerId = Integer.valueOf(id);
        return customerService.patchEmail(customerId, email);//<- missing return keyword 
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }

  @Override
  public Customer patchName(String id, String name) {
    if (!id.isBlank()) {
      try {
        long customerId = Integer.valueOf(id);
        return customerService.patchName(customerId, name);
      } catch (NumberFormatException e) {
        return null;
      }
    }
    return null;
  }

}
