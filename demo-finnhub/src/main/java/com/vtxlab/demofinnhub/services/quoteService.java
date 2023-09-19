package com.vtxlab.demofinnhub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demofinnhub.infra.exception.FinnhubException;
import com.vtxlab.demofinnhub.model.QuoteReqDto;
import com.vtxlab.demofinnhub.services.impl.QuoteServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuoteService implements QuoteServiceImpl {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  @Qualifier("quoteUriConfig") // public class finnhubUriBuilderConfig
  UriComponentsBuilder quoteUriConfig;

  // 就算@bean左，每get一次queryParam都自動疊加，要用.cloneBuilder() copy 條link先再.queryParam()
  private QuoteReqDto getPrice(String symbol) throws FinnhubException {
    // quoteUriConfig.cloneBuilder().queryParam("symbol", symbol)
    log.info("quote service quote uri : " + quoteUriConfig.cloneBuilder()
        .queryParam("symbol", symbol).toUriString());
    return restTemplate.getForObject(quoteUriConfig.cloneBuilder()
        .queryParam("symbol", symbol).toUriString(), QuoteReqDto.class);// dont use array [] , ,since the json is open at {}
  }


  @Override
  public QuoteReqDto getCompanyPrice(String symbol) throws FinnhubException {

    return getPrice(symbol);
  }
}
