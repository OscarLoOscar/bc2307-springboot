package com.hkjava.demo.demofinnhub.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.Code;
import com.hkjava.demo.demofinnhub.model.APImodel.CompanyProfile2DTO;
import com.hkjava.demo.demofinnhub.model.APImodel.Quote;
import com.hkjava.demo.demofinnhub.model.dto.Response.StockDTO;
import com.hkjava.demo.demofinnhub.model.dto.Response.StockGetFromDBDTO;
import com.hkjava.demo.demofinnhub.model.mapper.FinnhubMapper;
import com.hkjava.demo.demofinnhub.repository.StockPriceRepository;
import com.hkjava.demo.demofinnhub.repository.StockRepository;
import com.hkjava.demo.demofinnhub.service.CompanyService;
import com.hkjava.demo.demofinnhub.service.StockPriceService;
import com.hkjava.demo.demofinnhub.service.WebStockService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebStockServiceImpl implements WebStockService {

  @Autowired
  CompanyService companyService;

  @Autowired
  StockPriceService stockPriceService;

  @Autowired
  StockRepository stockRepository;

  @Autowired
  StockPriceRepository stockPriceRepository;

  @Autowired
  FinnhubMapper finnhubMapper;

  @Override
  public StockDTO stockInfo(String symbol) throws FinnhubException {
    CompanyProfile2DTO profile = companyService.getCompanyProfile(symbol);
    Quote quote = stockPriceService.getQuote(symbol);
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

  @Override
  public void addStock(Stock stock) throws FinnhubException {
    stockRepository.save(stock);
    log.info("Stock Add Success");
  }

}
