package com.hkjava.demo.demofinnhub.controller;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.hkjava.demo.demofinnhub.entity.BuyStock;
import com.hkjava.demo.demofinnhub.entity.SellStock;
import com.hkjava.demo.demofinnhub.entity.StockSymbol;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;
import com.hkjava.demo.demofinnhub.model.MakeTradeManager;
import com.hkjava.demo.demofinnhub.model.OrderBook;

public interface TransactionOperation {
    @PostMapping("/buy")
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResponse<Void> buyStock(@RequestBody BuyStock buyStock);

    @PostMapping("/sell")
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResponse<Void> sellStock(@RequestBody SellStock sellStock);

    @GetMapping("/order")
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResponse<MakeTradeManager> checkStock(@PathVariable String symbol) throws FinnhubException;

}
