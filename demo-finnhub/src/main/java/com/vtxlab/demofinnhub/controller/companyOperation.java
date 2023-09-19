package com.vtxlab.demofinnhub.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.infra.exception.BusinessException;
import com.vtxlab.demofinnhub.model.CompanyRequestDto;
import com.vtxlab.demofinnhub.model.CompanyRespDto;

public interface companyOperation {
  @GetMapping(value = "/AAPLAAPL")
  ResponseEntity<ApiResponse<List<CompanyRespDto>>> getCompanyData2();
  @GetMapping(value = "/AAPL")
  ResponseEntity<ApiResponse<List<CompanyRequestDto>>> getCompanyData();


}
