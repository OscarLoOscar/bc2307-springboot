package com.hkjava.demo.demofinnhub.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.hkjava.demo.demofinnhub.infra.Interval;
import lombok.Builder;

public class Line {
  // private String type : enum : DAY,WEEK,MONTH,HOUR,30_MINUTE
  private Interval interval;

  private String symbol;

  private Deque<Point> closePoints; // per month


  public Line(String symbol, Interval interval) {// DAY, WEEK, MONTH
    this.interval = interval; // month
    this.symbol = symbol;
    this.closePoints = new LinkedList<>();

    // Check if the symbol exists in the map before accessing it
    List<SourcePoint> sourcePoints = SourcePoint.sourceMap.get(symbol);
    if (sourcePoints != null) {
      Comparator<SourcePoint> reversed =
          (SourcePoint p1, SourcePoint p2) -> p1.getTranDayTime().getDatetime()
              .isAfter(p2.getTranDayTime().getDatetime()) ? -1 : 1;

      SourcePoint.sourceMap.get(symbol).stream()//
          .filter(s -> {
            if (interval == Interval.WEEK)
              return s.getTranDayTime().isWeeklyClose();
            else if (interval == Interval.MONTH)
              return s.getTranDayTime().isMonthlyClose();
            else // day
              return true;
          })//
          .sorted(reversed)//
          .forEach(s -> {
            closePoints.add(s.toPoint());
          });
    }
  }

  // instance method -> calculate
  public List<Point> movingAverage(int noOfInterval) {
    List<Point> movingAveragePoints = new ArrayList<>();
    Iterator<Point> iterator = closePoints.iterator();

    // Calculate the moving average for each point in the line
    for (int i = 0; i < closePoints.size(); i++) {
      BigDecimal sum = BigDecimal.ZERO;
      int count = 0;

      // Add the closing prices of the previous noOfInterval points to the sum
      for (int j = i; j > i - noOfInterval && j >= 0; j--) {
        if (iterator.hasNext()) {
          Point currentPoint = iterator.next();
          sum = sum
              .add(BigDecimal.valueOf(currentPoint.getClosePrice().getPrice()));
          count++;
        } else {
          break; // Ensure we don't go out of bounds
        }
      }

      // Calculate the moving average by dividing the sum by the number of points
      if (count > 0) {
        BigDecimal movingAverage =
            sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
        movingAveragePoints.add(new Point(movingAverage)); // Create a new Point object with the moving average
      }
    }

    return movingAveragePoints;
  }

  // Override the Getter
  public List<Point> getClosePoints(Deque<Point> closePoints) {
    List<Point> points = new ArrayList<>();
    points.addAll(this.closePoints);
    return points;
  }

  public List<Point> getClosePoints() {
    List<Point> points = new ArrayList<>();
    points.addAll(this.closePoints);
    return points;
  }

  public static void main(String[] args) {
    Line line = new Line("APAL", Interval.HOUR);
    line.getClosePoints().add(//
        List.of(//
          new Point(BigDecimal.valueOf(18.93)), //
            new Point(BigDecimal.valueOf(18.93))//
        ));
    System.out.println(line.movingAverage(10));
    // line.getClosePoints;
  }
}

