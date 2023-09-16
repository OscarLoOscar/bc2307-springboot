package com.hkjava.demo.demoshopping.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.hkjava.demo.demoshopping.model.Customer;

public interface CustomerOperation {

        // "/customer"-> we call it endpoint ，一定唔unique ->可重覆使用
        @GetMapping(value = "/customers") // noun, No verb
        List<Customer> findAll();

        @PostMapping(value = "/customer") // noun, No verb
        Customer create(@RequestParam(value = "name") String name, //
                        @RequestParam(value = "email") String email, //
                        @RequestParam(value = "dob") LocalDate dob);

        @PostMapping(value = "/createCustomer") // noun, No verb
        Customer createCustomer(@RequestBody Customer customer);

        @GetMapping(value = "/customer/{id}") // noun, No verb
        Customer find(@PathVariable(name = "id") String customerId);

        // Query : UPDATE TABLE ... SET ....WHERE ID = ....
        @PutMapping(value = "/customer/{id}") // ->用primary key 成條object更新 -> Put & Delete unique
        Customer update(@PathVariable(name = "id") String id, //
                        @RequestBody Customer customer);

        @PatchMapping(value = "/customer/id/{id}/email/{email}") // ->patch 可以多個：email，phone ... ->會撞
        Customer patchEmail(@PathVariable(name = "id") String id, //
                        @PathVariable(name = "email") String email);

        @PatchMapping(value = "/customer/id/{id}/name/{name}")
        Customer patchName(@PathVariable(name = "id") String id, //
                        @PathVariable(name = "name") String name);

        @DeleteMapping(value = "/customer/{id}")
        Customer remove(@PathVariable(name = "id") String customerId);
}
