package com.vtxlab.demofinnhub.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demofinnhub.controller.quoteOperation;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.model.CompanyRequestDto;
import com.vtxlab.demofinnhub.model.quoteReqDto;
import com.vtxlab.demofinnhub.services.quoteService;

@RestController
@RequestMapping(value = "/api/v1")
public class quoteController implements quoteOperation {

  @Autowired
  quoteService QuoteService;

  @Override
  public ResponseEntity<ApiResponse<quoteReqDto>> getCompanyPrice(String symbol) {
    quoteReqDto convent = QuoteService.getCompanyPrice(symbol);

    ApiResponse<quoteReqDto> response =
        ApiResponse.<quoteReqDto>builder()//
            .ok()//
            .data(convent)//
            .build();

    return ResponseEntity.ok().body(response);

  }


}
