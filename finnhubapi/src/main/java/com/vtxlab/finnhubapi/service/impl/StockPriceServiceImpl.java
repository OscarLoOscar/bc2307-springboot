package com.vtxlab.finnhubapi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.finnhubapi.exception.FinnhubException;
import com.vtxlab.finnhubapi.infra.Code;
import com.vtxlab.finnhubapi.infra.Protocol;
import com.vtxlab.finnhubapi.model.Quote;
import com.vtxlab.finnhubapi.service.StockPriceService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class StockPriceServiceImpl implements StockPriceService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  @Qualifier(value = "finnhubToken")
  private String token;

  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.base-url}")
  private String baseUrl;

  @Value(value = "${api.finnhub.endpoints.stock.quote}")
  private String quoteEndpoint;

  @Override
  public Quote getQuote(String symbol) throws FinnhubException {
    String priceUrl = UriComponentsBuilder.newInstance() //
        .scheme(Protocol.HTTPS.name()) //
        .host(domain) //
        .pathSegment(baseUrl) //
        .path(quoteEndpoint) //
        .queryParam("symbol", symbol) //
        .queryParam("token", token) //
        .build() //
        .toUriString();
    System.out.println("url=" + priceUrl);
    try {
      return restTemplate.getForObject(priceUrl, Quote.class);
    } catch (RestClientException e) {
      throw new FinnhubException(Code.FINNHUB_QUOTE_NOTFOUND);
    }
  }

}
