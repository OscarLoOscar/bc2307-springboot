package com.hkjava.demo.demofinnhub.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hkjava.demo.demofinnhub.controller.DataOperation;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.mapper.FinnhubMapper;
import com.hkjava.demo.demofinnhub.repository.StockRepository;
import com.hkjava.demo.demofinnhub.service.CompanyService;
import com.hkjava.demo.demofinnhub.service.StockPriceService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1")
public class DataController implements DataOperation {

  @Autowired
  private CompanyService companyService;

  @Autowired
  private StockPriceService stockPriceService;

  @Autowired
  private StockRepository stockRepository;

  @Autowired
  private FinnhubMapper finnhubMapper;

  @Override
  public List<Stock> findAll() {
    return companyService.findAll();
  }

  @Override
  public Stock save(Stock stock) {
    return companyService.save(stock);
  }

  @Override
  public void deleteById(Long id) {
    companyService.deleteById(id);
  }

  @Override
  public void updateById(Long id, Stock stock) {
    companyService.updateById(id, stock);
  }

  @Override
  public void updateCompanyNameById(Long id, String companyName) {
    companyService.updateCompanyNameById(id, companyName);
  }

  @Override
  public List<Stock> findByCountry(String country) {
    return companyService.findByCountry(country);
  }

  @Override
  public List<Stock> findAllById2(String id) {
    long conventId = (long) Integer.parseInt(id);
    return companyService.findAllById2(conventId);
  }

  @Override
  public Stock findAllById3(String id) {
    long conventId = (long) Integer.parseInt(id);
    return companyService.findAllById3(conventId);
  }

  @Override
  public void refreshCompanyProfile() throws FinnhubException {
    companyService.refresh();
  }

  @Override
  public StockPrice save(Long id, StockPrice stockPrice) {
    return stockPriceService.save(id, stockPrice);
  }

  @Override
  public List<Stock> findByCountryAndMarketCap(String country,
      double marketCap) {
        return companyService.findByCountryAndMarketCap(country, marketCap);  }

//   @Override
//   public List<StockPrice> getAllClosePrice(String symbol) {
// Long id ;
// if(companyService.getCompanyProfile(symbol).equals(symbol))
// id=stockRepository.
// return stockPriceService.getAllPrice(id);
//   }

}
