package com.vtxlab.demofinnhub.services.impl;

import java.util.List;
import com.vtxlab.demofinnhub.model.CompanyReqDto;
import com.vtxlab.demofinnhub.model.quoteReqDto;

public interface quoteServiceImpl {
    quoteReqDto getCompanyPrice(String symbol);

}
