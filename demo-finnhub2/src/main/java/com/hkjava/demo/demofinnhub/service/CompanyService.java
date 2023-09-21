package com.hkjava.demo.demofinnhub.service;

import java.util.List;
import org.springframework.data.repository.query.Param;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;

public interface CompanyService {

  CompanyProfile getCompanyProfile(String symbol) throws FinnhubException;

  void updateById(Long id, Stock stock);

  List<Stock> findAll();

  Stock save(Stock stock);

  void deleteById(Long id);

  void updateCompanyNameById(Long id, String companyName);

  List<Stock> findByCountry(String country);

  List<Stock> findAllById2(Long id);

  Stock findAllById3(Long id);

}
