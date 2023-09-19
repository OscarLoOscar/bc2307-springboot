package com.vtxlab.demofinnhub.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.model.quoteReqDto;

public interface quoteOperation {
  @GetMapping(value = "/price")
  ResponseEntity<ApiResponse<quoteReqDto>> getCompanyPrice(
      @RequestParam(value = "symbol") String symbol);

}
