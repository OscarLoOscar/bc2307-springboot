package com.example.demo.demostockexchange.AppConfig;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {


  @Bean
  ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  RestTemplate restTemplate() {// method name -> bean name
    return new RestTemplate();
  }

}
