package com.vtxlab.finnhubapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.finnhubapi.exception.FinnhubException;
import com.vtxlab.finnhubapi.infra.ApiResponse;
import com.vtxlab.finnhubapi.model.Symbol;

public interface SymbolOperation {
  @GetMapping(value = "/stockSymbol")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResponse<List<Symbol>> getStockSymbol() throws FinnhubException;

}
