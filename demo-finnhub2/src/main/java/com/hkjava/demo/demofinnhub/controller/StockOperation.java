package com.hkjava.demo.demofinnhub.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.hkjava.demo.demofinnhub.annotation.SymbolCheck;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.ApiResponse;
import com.hkjava.demo.demofinnhub.model.dto.Request.SymbolReqDTO;
import com.hkjava.demo.demofinnhub.model.dto.Response.CandleStickDTO;
import com.hkjava.demo.demofinnhub.model.dto.Response.StockDTO;
import com.hkjava.demo.demofinnhub.model.dto.Response.StockGetFromDBDTO;

public interface StockOperation {
        @GetMapping(value = "/stock")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResponse<StockDTO> stockInfo(@RequestParam("symbol") String symbol)
                        throws FinnhubException;

        @GetMapping(value = "/stock2")//?symbol=
        @ResponseStatus(value = HttpStatus.OK)
        ApiResponse<StockDTO> stockInfo2(
                        @SymbolCheck @RequestParam("symbol") SymbolReqDTO symbol)
                        throws FinnhubException;



        @GetMapping(value = "/stockfromdb")
        @ResponseStatus(value = HttpStatus.OK)
        ApiResponse<List<StockGetFromDBDTO>> stockInfoFromDb()
                        throws FinnhubException;

        @PostMapping(value = "/add/stock")
        @ResponseStatus(value = HttpStatus.OK)
        public ResponseEntity<Void> addStock(@RequestBody Stock stock)
                        throws FinnhubException;
}
