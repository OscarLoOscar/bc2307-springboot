package com.hkjava.demo.demofinnhub.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
// 畫上去個點
public class Point {

  public Point(BigDecimal movingAverage) {
    
  }

  private Price closePrice;

  private TranDayTime tranDateTime;// encapsulation , 唔寫LocalDay

}
