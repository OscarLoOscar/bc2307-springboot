package com.hkjava.demo.demofinnhub.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.Protocol;
import com.hkjava.demo.demofinnhub.model.StockSymbol;
import com.hkjava.demo.demofinnhub.service.SymbolService;

@Service
public class SymbolServiceImpl implements SymbolService {
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  @Qualifier(value = "finnhubToken")
  private String token;

  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.base-url}")
  private String baseUrl;


  @Value(value = "${api.finnhub.endpoints.stock.stocksymbol}")
  private String stocksymbolEndpoint;


  // @Autowired
  // SymbolRepository symbolRepository;

  @Override
  public List<StockSymbol> getStockSymbol(String exchange)
      throws FinnhubException {

    String url = UriComponentsBuilder.newInstance() //
        .scheme(Protocol.HTTPS.name()) //
        .host(domain) //
        .pathSegment(baseUrl) //
        .path(stocksymbolEndpoint) //
 //       .path(exchange)
        .queryParam("exchange", exchange) //
        .queryParam("token", token) //
        .build() //
        .toUriString();
    System.out.println("StockSymbol url = " + url);
    // try {
    return Arrays.asList(restTemplate.getForObject(url, StockSymbol[].class));

    // } catch (RestClientException e) {
    // throw new FinnhubException(Code.FINNHUB_PROFILE2_NOTFOUND);
    // }
  }
}
