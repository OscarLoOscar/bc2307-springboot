// package com.vtxlab.demofinnhub.controller.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.vtxlab.demofinnhub.controller.DtoOperation;
// import com.vtxlab.demofinnhub.infra.ApiResponse;
// import com.vtxlab.demofinnhub.model.CompanyRequestDto;
// import com.vtxlab.demofinnhub.model.quoteReqDto;
// import com.vtxlab.demofinnhub.model.Resp.totalRespSto;
// import com.vtxlab.demofinnhub.services.companyService;
// import com.vtxlab.demofinnhub.services.quoteService;

// @RestController
// @RequestMapping(value = "/api/v1")
// public class DtoController implements DtoOperation {

//   @Autowired
//   companyService CompanyService;

//   @Autowired
//   quoteService QuoteService;

//   @Override
//   public ResponseEntity<ApiResponse<totalRespSto>> getStock(String symbol) {
//     List<quoteReqDto> conventQuote = QuoteService.getCompanyPrice(symbol);
//     List<CompanyRequestDto> conventCompany =
//         CompanyService.getCompanyData(symbol);


//     ApiResponse<List<totalRespSto>> response =
//         ApiResponse.<List<totalRespSto>>builder()//
//             .ok()//
//             .data(convent)//
//             .build();

//     return ResponseEntity.ok().body(response);
//   }

// }