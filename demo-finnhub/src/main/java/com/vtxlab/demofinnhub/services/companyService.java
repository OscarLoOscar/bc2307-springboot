package com.vtxlab.demofinnhub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demofinnhub.model.CompanyReqDto;
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


  private CompanyReqDto getCompany(String symbol) {
    log.info("company service uri String : " + profileUriConfig.cloneBuilder()
        .queryParam("symbol", symbol).toUriString());
    return restTemplate.getForObject(profileUriConfig.cloneBuilder()
        .queryParam("symbol", symbol).toUriString(), CompanyReqDto.class);// dont use array [] , ,since the json is open at {}
  }

  @Override
  public CompanyReqDto getCompanyData(String symbol) {
    return getCompany(symbol);
  }



}
