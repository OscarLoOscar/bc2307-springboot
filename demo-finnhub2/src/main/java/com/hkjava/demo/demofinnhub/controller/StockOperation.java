package com.hkjava.demo.demofinnhub.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.hkjava.demo.demofinnhub.annotation.SymbolCheck;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.dto.Request.SymbolReqDTO;
import com.hkjava.demo.demofinnhub.model.dto.Response.StockDTO;
import com.hkjava.demo.demofinnhub.model.dto.Response.StockGetFromDBDTO;
import com.hkjava.demo.demofinnhub.infra.ApiResp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;

public interface StockOperation {
    @Operation(summary = "Get Finnhub Stock Data",
            description = "This endpoint retrieves a stock data from Finnhub Endpoints (/stock).",
            tags = "Get a Stock",
            parameters = {@Parameter(name = "SymbolReqDTO",
                    description = "Stock Symbol", required = true)})
    @ApiResponses({//
            @ApiResponse(responseCode = "200",
                    content = {@Content(
                            schema = @Schema(implementation = Stock.class),
                            mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    content = {@Content(schema = @Schema(implementation = ApiResp.class))}),
            @ApiResponse(responseCode = "500",
                    content = {@Content(schema = @Schema(implementation = ApiResp.class))})})
    @GetMapping(value = "/stock")
    @ResponseStatus(value = HttpStatus.OK)
    ApiResp<StockDTO> stockInfo(@RequestParam("symbol") String symbol)
            throws FinnhubException;

        @GetMapping(value = "/stock2") // ?symbol=
        @ResponseStatus(value = HttpStatus.OK)
        ApiResp<StockDTO> stockInfo2(
                        @SymbolCheck @RequestParam("symbol") SymbolReqDTO symbol)
                        throws FinnhubException;



        @GetMapping(value = "/stockfromdb")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResp<List<StockGetFromDBDTO>> stockInfoFromDb()
                        throws FinnhubException;

        @PostMapping(value = "/add/stock")
        @ResponseStatus(value = HttpStatus.OK)
        public ResponseEntity<Void> addStock(@RequestBody Stock stock)
                        throws FinnhubException;
}
