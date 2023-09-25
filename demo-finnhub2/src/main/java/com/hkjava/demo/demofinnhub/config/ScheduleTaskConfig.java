package com.hkjava.demo.demofinnhub.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduleTaskConfig {

  @Scheduled(fixedRate = 10000) // 10sec
  public void fixedRateTask() {
    System.out.println("FixedRate Task - " + System.currentTimeMillis());
  }

}
