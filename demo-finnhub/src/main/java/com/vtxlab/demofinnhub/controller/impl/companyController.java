package com.vtxlab.demofinnhub.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demofinnhub.controller.CompanyOperation;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.infra.exception.BizCode;
import com.vtxlab.demofinnhub.infra.exception.BusinessException;
import com.vtxlab.demofinnhub.infra.exception.FinnhubException;
import com.vtxlab.demofinnhub.infra.exception.invalidInputException;
import com.vtxlab.demofinnhub.model.CompanyReqDto;
import com.vtxlab.demofinnhub.services.CompanyService;

@RestController
@RequestMapping(value = "/api/v1")
public class CompanyController implements CompanyOperation {
  @Autowired
  CompanyService companyService;

  // @Override
  // public ResponseEntity<ApiResponse<List<CompanyRespDto>>> getCompanyData2() {
  // List<CompanyReqDto> convent = companyService.getCompanyData();

  // List<CompanyRespDto> output = convent.stream()//
  // .map(e -> companyMapper.map(e))//
  // .collect(Collectors.toList());
  // // log.info("2 " + output.toString());
  // ApiResponse<List<CompanyRespDto>> response =
  // ApiResponse.<List<CompanyRespDto>>builder()//
  // .ok()//
  // .data(output)//
  // .build();
  // // log.info("3 " + response.toString());
  // return ResponseEntity.ok().body(response);
  // }

  @Override
  public ResponseEntity<ApiResponse<CompanyReqDto>> getCompanyData(
      String symbol) throws FinnhubException, invalidInputException, invalidInputException {
    if (symbol.isBlank())
      throw new IllegalArgumentException("Symbol cannot blank");
    else if (symbol.chars().allMatch(Character::isDigit))
      throw new invalidInputException(BizCode.INVALID_INPUT);

    CompanyReqDto convent = companyService.getCompanyData(symbol);

    ApiResponse<CompanyReqDto> response = ApiResponse.<CompanyReqDto>builder()//
        .ok()//
        .data(convent)//
        .build();

    return ResponseEntity.ok().body(response);
  }


}
