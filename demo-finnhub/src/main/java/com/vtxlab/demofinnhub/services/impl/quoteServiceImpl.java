package com.vtxlab.demofinnhub.services.impl;

import java.util.List;
import com.vtxlab.demofinnhub.infra.exception.FinnhubException;
import com.vtxlab.demofinnhub.model.CompanyReqDto;
import com.vtxlab.demofinnhub.model.QuoteReqDto;

public interface QuoteServiceImpl {
    QuoteReqDto getCompanyPrice(String symbol) throws FinnhubException;

}
