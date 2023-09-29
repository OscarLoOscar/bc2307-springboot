package com.vtxlab.finnhubapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.finnhubapi.exception.FinnhubException;
import com.vtxlab.finnhubapi.infra.ApiResponse;
import com.vtxlab.finnhubapi.model.dto.StockDTO;

public interface StockOperation {

    @GetMapping(value = "/stock")
    @ResponseStatus(value = HttpStatus.OK)
    ApiResponse<StockDTO> stockInfo(@RequestParam("symbol") String symbol)
            throws FinnhubException;

}
