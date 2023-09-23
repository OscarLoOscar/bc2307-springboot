package com.hkjava.demo.demofinnhub.service.callAPI.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.Code;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;
import com.hkjava.demo.demofinnhub.model.Quote;
import com.hkjava.demo.demofinnhub.model.dto.StockDTO;
import com.hkjava.demo.demofinnhub.model.dto.StockGetFromDBDTO;
import com.hkjava.demo.demofinnhub.model.mapper.FinnhubMapper;
import com.hkjava.demo.demofinnhub.repository.StockPriceRepository;
import com.hkjava.demo.demofinnhub.repository.StockRepository;
import com.hkjava.demo.demofinnhub.service.callAPI.CompanyService;
import com.hkjava.demo.demofinnhub.service.callAPI.StockService;
import com.hkjava.demo.demofinnhub.service.callAPI.WebStockService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebStockServiceImpl implements WebStockService {

  @Autowired
  CompanyService companyService;

  @Autowired
  StockService stockService;

  @Autowired
  StockRepository stockRepository;

  @Autowired
  StockPriceRepository stockPriceRepository;

  @Autowired
  FinnhubMapper finnhubMapper;

  @Override
  public StockDTO stockInfo(String symbol) throws FinnhubException {
    CompanyProfile profile = companyService.getCompanyProfile(symbol);
    Quote quote = stockService.getQuote(symbol);
    if (profile == null && quote == null)
      throw new FinnhubException(Code.THIRD_PARTY_SERVER_UNAVAILABLE);
    return finnhubMapper.map(profile, quote);
  }

  @Override
  public List<StockGetFromDBDTO> stockInfo() throws FinnhubException {
    List<StockPrice> stockPrices = stockPriceRepository.findAll();
    List<Stock> stocks = stockRepository.findAll();
    log.info("WebStockServiceImpl ,stockPrices " + stockPrices);
    log.info("WebStockServiceImpl ,stocks " + stocks);

    if (stockPrices == null || stocks == null)
      throw new FinnhubException(Code.THIRD_PARTY_SERVER_UNAVAILABLE);
    return finnhubMapper.map(stocks, stockPrices);
  }

}
