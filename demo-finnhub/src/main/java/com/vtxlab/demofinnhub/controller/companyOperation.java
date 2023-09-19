package com.vtxlab.demofinnhub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.infra.exception.FinnhubException;
import com.vtxlab.demofinnhub.model.CompanyReqDto;

public interface CompanyOperation {
  @GetMapping(value = "/company")
  ResponseEntity<ApiResponse<CompanyReqDto>> getCompanyData(
      @RequestParam(name = "symbol") String symbol) throws FinnhubException;


}
