package com.hkjava.demo.demoshopping.controller;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hkjava.demo.demoshopping.model.Customer;

public interface CustomerOperation {

  @PostMapping(value = "/customer") // noun, No verb
  Customer create(@RequestParam String name, //
      @RequestParam String email, //
      @RequestParam LocalDate dob);

  @GetMapping(value = "/customer/{id}") // noun, No verb
  Customer find(@PathVariable(name = "id") String customerId);
}
