package com.vtxlab.demofinnhub.services;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.infra.exception.BizCode;
import com.vtxlab.demofinnhub.infra.exception.BusinessException;
import com.vtxlab.demofinnhub.infra.exception.GlobalExceptionHandle;
import com.vtxlab.demofinnhub.infra.exception.urlNotFoundException;
import com.vtxlab.demofinnhub.infra.util.UriScheme;
import com.vtxlab.demofinnhub.model.CompanyRequestDto;
import com.vtxlab.demofinnhub.services.impl.companyServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class companyService implements companyServiceImpl {


  @Autowired
  private RestTemplate restTemplate;


  @Autowired
  @Qualifier("profileUriConfig") // public class finnhubUriBuilderConfig
  UriComponentsBuilder profileUriConfig;


  private CompanyRequestDto getCompany(String symbol) {
    log.info("uri String : " + profileUriConfig.toUriString());
    return restTemplate.getForObject(profileUriConfig.toUriString(),
        CompanyRequestDto.class);// dont use array [] , ,since the json is open at {}
  }

  @Override
  public List<CompanyRequestDto> getCompanyData(String symbol) {
    CompanyRequestDto companyRequestDtos = getCompany(symbol);
    return Arrays.asList(companyRequestDtos);
  }



}
