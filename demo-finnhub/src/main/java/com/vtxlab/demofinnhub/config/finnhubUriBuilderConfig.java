package com.vtxlab.demofinnhub.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demofinnhub.infra.ApiResponse;
import com.vtxlab.demofinnhub.infra.util.ApiUtil;
import com.vtxlab.demofinnhub.infra.util.UriScheme;
import com.vtxlab.demofinnhub.model.CompanyRequestDto;

@Configuration
public class finnhubUriBuilderConfig {
  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.endpoint}")
  private String endpoint;

  @Value(value = "${api.finnhub.pathSegment}")
  private String pathSegment;

  @Value(value = "${api.finnhub.pathSegment2}")
  private String pathSegment2;

  @Value(value = "${api.finnhub.symbol}")
  private String symbol;

  @Value(value = "${api.finnhub.token}")
  private String token;

  @Bean
  UriComponentsBuilder finnhubUriConfig() {
    MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    queryParams.add("symbol", symbol);
    queryParams.add("token", token);
    // checking
    String url = UriComponentsBuilder.newInstance()//
        .scheme(UriScheme.HTTPS.name())//
        .host(domain)//
        .path(endpoint) //
        .path(pathSegment) //
        .path(pathSegment2) //
        .queryParam("symbol", symbol) //
        .queryParam("token", token) //
        .toUriString();
    System.out.println("url : " + url);
    // HTTPS://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=cju3it9r01qr958213c0cju3it9r01qr958213cg

    // check 2
    UriComponentsBuilder test = ApiUtil.uriBuilder(UriScheme.HTTPS, domain,
        endpoint, queryParams, pathSegment, pathSegment2);
    // https://finnhub.io/%2Fstock/%2Fprofile2/AAPL/cju3it9r01qr958213c0cju3it9r01qr958213cg/api/v1
    System.out.println("test : " + test.toUriString());
    return ApiUtil.uriBuilder(UriScheme.HTTPS, domain, endpoint, queryParams,
        pathSegment, pathSegment2);
  }

}
