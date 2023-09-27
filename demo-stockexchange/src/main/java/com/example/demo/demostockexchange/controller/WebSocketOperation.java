package com.example.demo.demostockexchange.controller;

import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo.demostockexchange.entity.Customer;
import com.example.demo.demostockexchange.entity.Orders;
import com.example.demo.demostockexchange.infra.ApiResponse;

public interface WebSocketOperation {
    @GetMapping("/updateOrderBook")
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResponse<List<Orders>> updateOrderBook();

    // target :
    @PostMapping("/{orderType}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> placeOrder(@PathVariable String orderType,
            @RequestBody OrderRequest orderRequest);


    // @PostMapping("/buy-stop")
    // @ResponseStatus(HttpStatus.OK)
    // public ApiResponse<Void> createBuyStopOrder(@RequestBody OrderRequest orderRequest) ;

    // @PostMapping("/sell-stop")
    // @ResponseStatus(HttpStatus.OK)
    // public ApiResponse<Void> createSellStopOrder(@RequestBody OrderRequest orderRequest) ;

    // @PostMapping("/buy-limit")
    // @ResponseStatus(HttpStatus.OK)
    // public ApiResponse<Void> createBuyLimitOrder(@RequestBody OrderRequest orderRequest) ;

    // @PostMapping("/sell-limit")
    // @ResponseStatus(HttpStatus.OK)
    // public ApiResponse<Void> createSellLimitOrder(@RequestBody OrderRequest orderRequest);

    // @PostMapping("/ask")
    // @ResponseStatus(HttpStatus.OK)
    // public ApiResponse<Void> createAskOrder(@RequestBody OrderRequest orderRequest) ;

    // @PostMapping("/bid")
    // @ResponseStatus(HttpStatus.OK)
    // public ApiResponse<Void> createBidOrder(@RequestBody OrderRequest orderRequest) ;


}
