package com.vtxlab.demofinnhub.services.impl;

import com.vtxlab.demofinnhub.infra.exception.FinnhubException;
import com.vtxlab.demofinnhub.model.CompanyReqDto;

public interface CompanyServiceImpl {
  CompanyReqDto getCompanyData(String symbol) throws FinnhubException;

}
