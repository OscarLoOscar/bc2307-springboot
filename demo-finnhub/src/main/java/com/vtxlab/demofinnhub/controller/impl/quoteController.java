package com.vtxlab.demofinnhub.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demofinnhub.controller.QuoteOperation;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.infra.exception.BizCode;
import com.vtxlab.demofinnhub.infra.exception.BusinessException;
import com.vtxlab.demofinnhub.infra.exception.FinnhubException;
import com.vtxlab.demofinnhub.infra.exception.invalidInputException;
import com.vtxlab.demofinnhub.model.CompanyReqDto;
import com.vtxlab.demofinnhub.model.QuoteReqDto;
import com.vtxlab.demofinnhub.services.QuoteService;

@RestController
@RequestMapping(value = "/api/v1")
public class QuoteController implements QuoteOperation {

  @Autowired
  QuoteService QuoteService;

  @Override
  public ResponseEntity<ApiResponse<QuoteReqDto>> getCompanyPrice(String symbol)
      throws FinnhubException, invalidInputException, invalidInputException {
    if (symbol.isBlank())
      throw new IllegalArgumentException("Symbol cannot blank");
    else if (symbol.chars().allMatch(Character::isDigit))
      throw new invalidInputException(BizCode.INVALID_INPUT);

    QuoteReqDto convent = QuoteService.getCompanyPrice(symbol);

    ApiResponse<QuoteReqDto> response = ApiResponse.<QuoteReqDto>builder()//
        .ok()//
        .data(convent)//
        .build();

    return ResponseEntity.ok().body(response);

  }


}
