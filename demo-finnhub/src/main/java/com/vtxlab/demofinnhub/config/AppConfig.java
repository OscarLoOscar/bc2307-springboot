package com.vtxlab.demofinnhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

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
