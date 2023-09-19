package com.vtxlab.demofinnhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class AppConfig {
  /*
   * RestTemplate : 人地寫好既library，invote 人地
   */
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate(); // lots if state
  }

  @Bean
  String String() {
    return new String();
  }

}
