package com.hkjava.demo.demoshopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // annotation on class ONLY
public class AppConfig {

  @Bean // annotation on method ONLY
  RestTemplate restTemplate() {// public , private , nothing
    return new RestTemplate();
  }
  // pulbic , every Class can call
  // nothing - > within 呢個package 既class先call到
}
