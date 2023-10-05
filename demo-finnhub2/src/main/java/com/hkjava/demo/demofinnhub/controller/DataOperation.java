package com.hkjava.demo.demofinnhub.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface DataOperation {

    @Operation(summary = "Insert Stock Data into DataBase", //
            description = "This endpoint is to insert stock data into database", //
            tags = "Save a Stock")
    @ApiResponses({//
            @ApiResponse(responseCode = "200", //
                    content = {@Content(
                            schema = @Schema(implementation = Stock.class), //
                            mediaType = "application/json")}), //
            @ApiResponse(responseCode = "404", //
                    content = {@Content(schema = @Schema())}), //
            @ApiResponse(responseCode = "500", //
                    content = {@Content(schema = @Schema())})})
    @PostMapping(value = "/data/stock")
    @ResponseStatus(value = HttpStatus.OK)
    Stock save(@RequestBody Stock stock);


    @Operation(summary = "Insert Stock Data into DataBase", //
            description = "This endpoint is to insert stock data into database", //
            tags = "Find All Stock")
    @ApiResponses({//
            @ApiResponse(responseCode = "200", //
                    content = {@Content(
                            schema = @Schema(implementation = Stock.class), //
                            mediaType = "application/json")}), //
            @ApiResponse(responseCode = "404", //
                    content = {@Content(schema = @Schema())}), //
            @ApiResponse(responseCode = "500", //
                    content = {@Content(schema = @Schema())})})
    @GetMapping(value = "/data/stocks")
    @ResponseStatus(value = HttpStatus.OK)
    List<Stock> findAll();

    @GetMapping(value = "/data/stock/country/{country}/marketcap/{marketCap}")
    @ResponseStatus(value = HttpStatus.OK)
    List<Stock> findByCountryAndMarketCap(@PathVariable String country,
            @PathVariable double marketCap);


    @GetMapping(value = "/data/stock/country/{country}")
    @ResponseStatus(value = HttpStatus.OK)
    List<Stock> findByCountry(@PathVariable String country);

    //
    @GetMapping(value = "/data/refresh/stock")
    @ResponseStatus(value = HttpStatus.OK)
    void refreshCompanyProfile() throws FinnhubException;
    //

    @GetMapping(value = "/data/stock/id2/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    List<Stock> findAllById2(@PathVariable String id);

    @GetMapping(value = "/data/stock/id3/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    Stock findAllById3(@PathVariable String id);

    @DeleteMapping(value = "/data/stock/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    void deleteById(@PathVariable Long id);

    @PutMapping(value = "/data/stock/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    void updateById(@PathVariable Long id, @RequestBody Stock stock);

    @PatchMapping(value = "/data/stock/id/{id}/companyname/{companyName}")
    @ResponseStatus(value = HttpStatus.OK)
    void updateCompanyNameById(@PathVariable Long id,
            @PathVariable String companyName);

    @PostMapping(value = "/data/stock/{id}/price")
    @ResponseStatus(value = HttpStatus.OK)
    StockPrice save(@PathVariable Long id, @RequestBody StockPrice stockPrice);

    // @GetMapping(value = "/data/stock/symbol/{symbol}")
    // @ResponseStatus(value = HttpStatus.OK)
    // List<StockPrice> getAllClosePrice(@PathVariable String symbol);

}
