package com.hkjava.demo.demofinnhub.model.Graph;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
// 畫上去個點
public class Point {

  public Point(BigDecimal movingAverage) {

  }

  public Point(double closePrice, TranDayTime tranDayTime) {
    this.closePrice = new Price(closePrice);
    this.tranDateTime = tranDayTime;
  }

  private Price closePrice;

  private TranDayTime tranDateTime;// encapsulation , 唔寫LocalDay

}
