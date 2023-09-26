package com.hkjava.demo.demofinnhub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.hkjava.demo.demofinnhub.entity.BuyStock;
import com.hkjava.demo.demofinnhub.entity.SellStock;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;

public interface TransactionOperation {
    @PostMapping("/buy")
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResponse<Void> buyStock(@RequestBody BuyStock buyStock);

    @PostMapping("/sell")
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResponse<Void> sellStock(@RequestBody SellStock sellStock);
}
