package com.vtxlab.demofinnhub.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demofinnhub.controller.DtoOperation;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.infra.exception.FinnhubException;
import com.vtxlab.demofinnhub.mapper.Mapper;
import com.vtxlab.demofinnhub.model.CompanyReqDto;
import com.vtxlab.demofinnhub.model.QuoteReqDto;
import com.vtxlab.demofinnhub.model.Resp.totalRespSto;
import com.vtxlab.demofinnhub.services.CompanyService;
import com.vtxlab.demofinnhub.services.QuoteService;

@RestController
@RequestMapping(value = "/api/v1")
public class DtoController implements DtoOperation {

  @Autowired
  CompanyService CompanyService;

  @Autowired
  QuoteService quoteService;

  @Override
  public ResponseEntity<ApiResponse<totalRespSto>> getStock(String symbol)
      throws FinnhubException {
    CompanyReqDto conventCompany = CompanyService.getCompanyData(symbol);
    QuoteReqDto conventQuote = quoteService.getCompanyPrice(symbol);

    totalRespSto output = Mapper.map(conventCompany, conventQuote);
    // System.out.println("DTO : " + output);
    ApiResponse<totalRespSto> response = ApiResponse.<totalRespSto>builder()//
        .ok()//
        .data(output)//
        .build();

    return ResponseEntity.ok().body(response);
  }

}
