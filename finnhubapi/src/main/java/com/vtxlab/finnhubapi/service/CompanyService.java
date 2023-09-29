package com.vtxlab.finnhubapi.service;

import java.util.List;
import com.vtxlab.finnhubapi.exception.FinnhubException;
import com.vtxlab.finnhubapi.model.CompanyProfile;

public interface CompanyService {

  CompanyProfile getCompanyProfile(String symbol) throws FinnhubException;

  // void refresh() throws FinnhubException;
  // // return CompanyProfile又得，void 又得 , seems like PutMapping

  // void deleteById(Long id);

  // void deleteAll();

  // void updateCompanyNameById(Long id, String companyName);

}
