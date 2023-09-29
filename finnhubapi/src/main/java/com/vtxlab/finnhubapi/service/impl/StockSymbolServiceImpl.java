package com.vtxlab.finnhubapi.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.finnhubapi.exception.FinnhubException;
import com.vtxlab.finnhubapi.infra.Protocol;
import com.vtxlab.finnhubapi.model.Symbol;
import com.vtxlab.finnhubapi.model.mapper.FinnhubMapper;
import com.vtxlab.finnhubapi.service.StockSymbolService;

@Service
public class StockSymbolServiceImpl implements StockSymbolService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private FinnhubMapper finnhubMapper;


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
  public List<Symbol> getStockSymbol() throws FinnhubException {

    String symbolUrl = UriComponentsBuilder.newInstance() //
        .scheme(Protocol.HTTPS.name()) //
        .host(domain) //
        .pathSegment(baseUrl) //
        .path(stocksymbolEndpoint) //
        .queryParam("exchange", "US") //
        .queryParam("token", token) //
        .build() //
        .toUriString();
    System.out.println("StockSymbol url = " + symbolUrl);
    // try {
    return Arrays.asList(restTemplate.getForObject(symbolUrl, Symbol[].class));

    // } catch (RestClientException e) {
    // throw new FinnhubException(Code.FINNHUB_PROFILE2_NOTFOUND);
    // }
  }

}
