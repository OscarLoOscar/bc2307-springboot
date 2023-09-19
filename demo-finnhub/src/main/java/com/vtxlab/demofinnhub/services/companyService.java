package com.vtxlab.demofinnhub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
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
    // UriComponentsBuilder builder = profileUriConfig; // Get the base builder
    // profileUriConfig.queryParam("symbol", symbol);// controller input param 放入bean get 新link
    log.info("service uri String : "
        + profileUriConfig.queryParam("symbol", symbol).toUriString());
    return restTemplate.getForObject(profileUriConfig.toUriString(),
        CompanyRequestDto.class);// dont use array [] , ,since the json is open at {}
  }

  @Override
  public CompanyRequestDto getCompanyData(String symbol) {
    CompanyRequestDto companyRequestDtos = getCompany(symbol);
    return companyRequestDtos;
  }



}
