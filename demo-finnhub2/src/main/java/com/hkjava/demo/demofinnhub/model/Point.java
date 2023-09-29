package com.hkjava.demo.demofinnhub.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Point {

  private Price closePrice;

  private TranDayTime tranDateTime;

}
