package com.vtxlab.demofinnhub.services.impl;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.infra.exception.BusinessException;
import com.vtxlab.demofinnhub.model.CompanyRequestDto;

public interface companyServiceImpl {
  List<CompanyRequestDto> getCompanyData();

}
