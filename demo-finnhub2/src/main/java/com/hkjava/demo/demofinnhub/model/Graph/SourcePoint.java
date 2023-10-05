package com.hkjava.demo.demofinnhub.model.Graph;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// database ?
// -> transactions (real life)
// -> Stock Price per day per stock (Project)
@Getter
@Setter
public class SourcePoint {

  public static Map<String, List<SourcePoint>> sourceMap = new HashMap<>();

  // in real life, this should be Interval.MIN_1
  private Interval interval = Interval.DAY;

  private Price closePrice;

  private TranDayTime tranDayTime;

  public SourcePoint(double closePoint, TranDayTime tranDayTime) {
    this.closePrice = closePrice;
    this.tranDayTime = tranDayTime;
  }

  public SourcePoint(double closePoint, LocalDateTime localDateTime) {
    this.closePrice = new Price(closePoint);
    this.tranDayTime = new TranDayTime(localDateTime);
  }

  public SourcePoint(double closePoint, LocalDate localDate) {
    this.closePrice = new Price(closePoint);
    this.tranDayTime = new TranDayTime(localDate.atStartOfDay());
  }

  // 當mapper用
  public Point toPoint() {
    return Point.builder() //
        .closePrice(this.closePrice) //
        .tranDateTime(this.tranDayTime) //
        .build();
  }

  public static Map<String, List<SourcePoint>> getSourceMap() {
    return sourceMap;
  }
}
