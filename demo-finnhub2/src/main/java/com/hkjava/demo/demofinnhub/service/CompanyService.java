package com.hkjava.demo.demofinnhub.service;

import java.util.List;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.APImodel.CompanyProfile2DTO;

public interface CompanyService {

  CompanyProfile2DTO getCompanyProfile(String symbol) throws FinnhubException;

  public CompanyProfile2DTO getCompanyProfileSaveInRedis(String symbol) throws FinnhubException;

  void refresh() throws FinnhubException;
  // return CompanyProfile又得，void 又得 , seems like PutMapping

  void updateById(Long id, Stock stock);

  List<Stock> findAll();

  List<Stock> findByCountryAndMarketCap(String country, double marketCap);

  Stock save(Stock stock);

  void deleteById(Long id);

  void deleteAll();

  void updateCompanyNameById(Long id, String companyName);

  List<Stock> findByCountry(String country);

  List<Stock> findAllById2(Long id);

  Stock findAllById3(Long id);
}
