package com.vtxlab.demofinnhub.services;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demofinnhub.model.quoteReqDto;
import com.vtxlab.demofinnhub.services.impl.quoteServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class quoteService implements quoteServiceImpl {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  @Qualifier("quoteUriConfig") // public class finnhubUriBuilderConfig
  UriComponentsBuilder quoteUriConfig;

  private quoteReqDto getPrice(String symbol) {
    // UriComponentsBuilder builder = quoteUriConfig;
    // quoteUriConfig.queryParam( symbol);
    log.info("service quote uri : "
        + quoteUriConfig.queryParam("symbol", symbol).toUriString());
    return restTemplate.getForObject(quoteUriConfig.toUriString(),
        quoteReqDto.class);// dont use array [] , ,since the json is open at {}
  }


  @Override
  public quoteReqDto getCompanyPrice(String symbol) {
    quoteReqDto QuoteReqDto = getPrice(symbol);//
    return QuoteReqDto;
  }
}
