package com.vtxlab.admin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.admin.entity.Stock;
import com.vtxlab.admin.entity.StockPrice;
import com.vtxlab.admin.exception.FinnhubException;
import com.vtxlab.admin.model.mapper.FinnhubMapper;
import com.vtxlab.admin.repository.StockRepository;
import com.vtxlab.admin.service.CompanyService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
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

//   @Override
//   public List<StockPrice> getAllClosePrice(String symbol) {
// Long id ;
// if(companyService.getCompanyProfile(symbol).equals(symbol))
// id=stockRepository.
// return stockPriceService.getAllPrice(id);
//   }

}
