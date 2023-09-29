package com.vtxlab.admin.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
// import com.vtxlab.finnhubapi.infra.RedisHelper;
// import com.vtxlab.finnhubapi.infra.RedisObjectMapper;
// import com.vtxlab.finnhubapi.infra.StockRestTemplate;

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

  // @Bean
  // StockRestTemplate stockRestTemplate(RestTemplate restTemplate) {// 自動去context搵
  //   return new StockRestTemplate(restTemplate);
  // }// run code 前，要有時間行restTemplate參數

  @Bean
  RestTemplate restTemplate() {// method name -> bean name
    return new RestTemplate();
  }

  // @Bean
  // ObjectMapper redisObjectMapper() {
  //   return RedisObjectMapper.of();
  // }

  // @Bean
  // RedisHelper redisProfileHelper(RedisConnectionFactory factory, //
  //     ObjectMapper redisObjectMapper) {
  //   return new RedisHelper(factory, redisObjectMapper);
  // }
}
