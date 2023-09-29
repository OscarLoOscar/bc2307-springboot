package com.example.demo.demostockexchange.controller;

import java.util.List;
import java.util.Queue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo.demostockexchange.exception.ApiResponse;
import com.example.demo.demostockexchange.model.OrderRequest;

public interface WebSocketOperation {
    @GetMapping("/updateOrderBook")
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResponse<List<OrderRequest>> updateOrderBook();

    // target :
    @PostMapping("/{orderType}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> placeOrder(@RequestBody OrderRequest orderRequest);

    @GetMapping("/buyQueue")
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResponse<Queue<OrderRequest>> buyOrdersQueue();

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
