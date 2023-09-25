package com.hkjava.demo.demofinnhub.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@EnableScheduling
// @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class ScheduleTaskConfig {
  // fixed rate 係base on task 行幾耐既話，就應該係隔 10S , 依家隔15s
  public static boolean start = false;

  @Scheduled(fixedRate = 10000) // 10sec
  public void fixedRateTask() throws InterruptedException {
    if (start) {
      System.out.println("FixedRate Task - " + System.currentTimeMillis());
      Thread.sleep(15000L);// doing task ... 5 seconds

    }
  }

  @Scheduled(fixedRate = 4000) // 4sec
  public void fixedDelayTask() throws InterruptedException {
    if (start) {
      System.out.println("FixedDelay Task - " + System.currentTimeMillis());
      Thread.sleep(5000L);// doing task ... 5 seconds
    }
  }


  @Scheduled(cron = " 0/30 * 9-23 * * MON-FRI") // set this String to yml
  public void fixedTimeTask() throws InterruptedException {
    if (start) {
      System.out.println("FixedTime Task - " + System.currentTimeMillis());
      Thread.sleep(5000L);// doing task ... 5 seconds

    }
  }


}
