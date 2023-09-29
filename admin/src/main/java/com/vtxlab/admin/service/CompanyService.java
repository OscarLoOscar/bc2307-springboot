package com.vtxlab.admin.service;

import java.util.List;
import com.vtxlab.admin.entity.Stock;
import com.vtxlab.admin.exception.FinnhubException;
public interface CompanyService {

  CompanyProfile getCompanyProfile(String symbol) throws FinnhubException;

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
