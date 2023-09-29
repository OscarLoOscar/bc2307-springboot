package com.vtxlab.demofinnhub.infra.util;

import java.net.URI;
import java.util.Map;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class ApiUtil {

  // public static UriComponentsBuilder uriBuilder(UriScheme scheme, String domain, String endpoint) {
  // return UriComponentsBuilder.newInstance()
  // .scheme(scheme.getProtocol())
  // .host(domain)
  // .path(endpoint);
  // }

  public static UriComponentsBuilder uriBuilder(UriScheme scheme, String domain, //
      String endpoint, String... pathSegments) {
    return UriComponentsBuilder.newInstance().scheme(scheme.getProtocol())
        .host(domain).pathSegment(pathSegments) // add slashes automatically
        .path(endpoint);
  }

  public static UriComponentsBuilder uriBuilder(UriScheme scheme, String domain,
      String endpoint, //
      String pathSegment, String pathSegment2, //
      String... pathSegments) {
    return UriComponentsBuilder.newInstance().scheme(UriScheme.HTTPS.name())
        .host(domain).path(endpoint)//
        .path(pathSegment) //
        .path(pathSegment2) //
        .pathSegment(pathSegments) // add slashes automatically
        .path(endpoint);
  }
  // public static UriComponentsBuilder uriBuilder(UriScheme scheme, String domain, String endpoint,
  // MultiValueMap<String, String> queryParams) {
  // return UriComponentsBuilder.newInstance()
  // .scheme(scheme.getProtocol())
  // .host(domain)
  // .path(endpoint)
  // .queryParams(queryParams);
  // }

  public static UriComponentsBuilder uriBuilder(UriScheme scheme, String domain,
      String endpoint, MultiValueMap<String, String> queryParams,
      String... pathSegments) {
    return UriComponentsBuilder.newInstance()//
        .scheme(scheme.getProtocol())//
        .host(domain)//
        .path(endpoint)//
        .pathSegment(pathSegments) // add slashes automatically
        .queryParams(queryParams);
  }

  public static URI uriBuilder(UriScheme scheme, String domain, String endpoint,
      Map<String, String> pathVariables,
      MultiValueMap<String, String> queryParams, String... pathSegments) {
    return UriComponentsBuilder.newInstance().scheme(scheme.getProtocol())
        .host(domain).pathSegment(pathSegments) // add slashes automatically
        .path(endpoint).queryParams(queryParams).build(pathVariables);
  }

}
