package com.hkjava.demo.demofinnhub.config;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hkjava.demo.demofinnhub.infra.StockRestTemplate;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;

@Configuration
public class AppConfig {

  @Value(value = "${api.finnhub.token}")
  private String token;

  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  String finnhubToken() {
    return token;
  }

  @Bean
  StockRestTemplate stockRestTemplate(RestTemplate restTemplate) {// 自動去context搵
    return new StockRestTemplate(restTemplate);
  }// run code 前，要有時間行restTemplate參數

  @Bean
  RestTemplate restTemplate() {// method name -> bean name
    return new RestTemplate();
  }

  @Bean
  RedisTemplate<String , CompanyProfile> redisProfileHelper(){
    return new RedisTemplate<>(new RedisTemplate<String,CompanyProfile>());
  }
}
