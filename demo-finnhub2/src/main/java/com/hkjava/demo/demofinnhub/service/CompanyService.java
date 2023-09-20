package com.hkjava.demo.demofinnhub.service;

import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;

public interface CompanyService {
  
  CompanyProfile getCompanyProfile(String symbol) throws FinnhubException;

  Stock save(Stock stock);

  void deleteById(Long id);
  
}
