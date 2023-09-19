package com.vtxlab.demofinnhub.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.model.quoteReqDto;
import com.vtxlab.demofinnhub.model.Resp.totalRespSto;

public interface DtoOperation {
  @GetMapping(value = "/stock")
  ResponseEntity<ApiResponse<totalRespSto>> getStock(
      @RequestParam(value = "symbol") String symbol);

}
