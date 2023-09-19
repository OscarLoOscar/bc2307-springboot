package com.vtxlab.demofinnhub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demofinnhub.infra.util.ApiUtil;
import com.vtxlab.demofinnhub.infra.util.UriScheme;

@Configuration
public class finnhubUriBuilderConfig {
  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.endpoint}")
  private String endpoint;

  @Value(value = "${api.finnhub.quote.pathSegment}")
  private String quotePathSegment;

  @Value(value = "${api.finnhub.profile.pathSegment}")
  private String profilePathSegment;

  @Value(value = "${api.finnhub.profile.pathSegment2}")
  private String profilePathSegment2;

  // @Value(value = "${api.finnhub.symbol}")
  // private String symbol;

  @Value(value = "${api.finnhub.token}")
  private String token;

  @Bean
  UriComponentsBuilder profileUriConfig() {
    // MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    // queryParams.add("symbol", symbol);
    // queryParams.add("token", token);
    return UriComponentsBuilder.newInstance()//
        .scheme(UriScheme.HTTPS.name())//
        .host(domain)//
        .path(endpoint)//
        .pathSegment(profilePathSegment) // add slashes automatically
        .pathSegment(profilePathSegment2)//
        .queryParam("token", token);//
  }

  @Bean
  UriComponentsBuilder quoteUriConfig() {
    // MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
    // queryParams.add("symbol", symbol);
    // queryParams.add("token", token);
    return UriComponentsBuilder.newInstance()//
        .scheme(UriScheme.HTTPS.name())//
        .host(domain)//
        .path(endpoint)//
        .pathSegment(quotePathSegment)//
        .queryParam("token", token)//
    ;
    // .build()//
    // .toUriString();;
  }

}
