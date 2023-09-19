package com.vtxlab.demofinnhub.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demofinnhub.controller.companyOperation;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.infra.exception.BusinessException;
import com.vtxlab.demofinnhub.model.CompanyRequestDto;
import com.vtxlab.demofinnhub.model.Resp.totalRespSto;
import com.vtxlab.demofinnhub.services.companyService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1")
public class companyController implements companyOperation {
  @Autowired
  companyService companyService;

  // @Override
  // public ResponseEntity<ApiResponse<List<CompanyRespDto>>> getCompanyData2() {
  // List<CompanyRequestDto> convent = companyService.getCompanyData();

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
  public ResponseEntity<ApiResponse<CompanyRequestDto>> getCompanyData(
      String symbol) {

    CompanyRequestDto convent = companyService.getCompanyData(symbol);

    ApiResponse<CompanyRequestDto> response =
        ApiResponse.<CompanyRequestDto>builder()//
            .ok()//
            .data(convent)//
            .build();

    return ResponseEntity.ok().body(response);
  }


}
