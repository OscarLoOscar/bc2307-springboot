package com.vtxlab.finnhubapi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.finnhubapi.exception.FinnhubException;
import com.vtxlab.finnhubapi.infra.Code;
import com.vtxlab.finnhubapi.model.CompanyProfile;
import com.vtxlab.finnhubapi.model.Quote;
import com.vtxlab.finnhubapi.model.dto.StockDTO;
import com.vtxlab.finnhubapi.model.mapper.FinnhubMapper;
import com.vtxlab.finnhubapi.service.CompanyService;
import com.vtxlab.finnhubapi.service.StockPriceService;
import com.vtxlab.finnhubapi.service.WebStockService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebStockServiceImpl implements WebStockService {

  @Autowired
  CompanyService companyService;

  @Autowired
  StockPriceService stockPriceService;

  @Autowired
  FinnhubMapper finnhubMapper;

  @Override
  public StockDTO stockInfo(String symbol) throws FinnhubException {
    CompanyProfile profile = companyService.getCompanyProfile(symbol);
    Quote quote = stockPriceService.getQuote(symbol);
    if (profile == null && quote == null)
      throw new FinnhubException(Code.THIRD_PARTY_SERVER_UNAVAILABLE);
    return finnhubMapper.map(profile, quote);
  }

  // @Override
  // public List<StockGetFromDBDTO> stockInfo() throws FinnhubException {
  //   List<StockPrice> stockPrices = stockPriceRepository.findAll();
  //   List<Stock> stocks = stockRepository.findAll();
  //   log.info("WebStockServiceImpl ,stockPrices " + stockPrices);
  //   log.info("WebStockServiceImpl ,stocks " + stocks);

  //   if (stockPrices == null || stocks == null)
  //     throw new FinnhubException(Code.THIRD_PARTY_SERVER_UNAVAILABLE);
  //   return finnhubMapper.map(stocks, stockPrices);
  // }



}
