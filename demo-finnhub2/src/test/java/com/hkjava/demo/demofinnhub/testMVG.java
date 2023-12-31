package com.hkjava.demo.demofinnhub;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.mockStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.hkjava.demo.demofinnhub.model.Graph.Interval;
import com.hkjava.demo.demofinnhub.model.Graph.Line;
import com.hkjava.demo.demofinnhub.model.Graph.Point;
import com.hkjava.demo.demofinnhub.model.Graph.Price;
import com.hkjava.demo.demofinnhub.model.Graph.SourcePoint;
import com.hkjava.demo.demofinnhub.model.Graph.TranDayTime;

@SpringBootTest
public class testMVG {

  private static Map<String, List<SourcePoint>> mockSrcMAp;

  @Test
  public void init() {
    mockSrcMAp = new HashMap<>();
    List<SourcePoint> sourcePoints = new ArrayList<>();
    sourcePoints.add(new SourcePoint(10.0d, LocalDate.of(2023, 9, 11)));
    sourcePoints.add(new SourcePoint(12.0d, LocalDate.of(2023, 9, 12)));
    sourcePoints.add(new SourcePoint(14.0d, LocalDate.of(2023, 9, 13)));
    sourcePoints.add(new SourcePoint(16.0d, LocalDate.of(2023, 9, 14)));
    sourcePoints.add(new SourcePoint(18.0d, LocalDate.of(2023, 9, 15)));
    sourcePoints.add(new SourcePoint(20.0d, LocalDate.of(2023, 9, 18)));
    sourcePoints.add(new SourcePoint(22.0d, LocalDate.of(2023, 9, 19)));
    sourcePoints.add(new SourcePoint(24.0d, LocalDate.of(2023, 9, 20)));
    sourcePoints.add(new SourcePoint(26.0d, LocalDate.of(2023, 9, 21)));
    sourcePoints.add(new SourcePoint(28.0d, LocalDate.of(2023, 9, 22)));
    sourcePoints.add(new SourcePoint(30.0d, LocalDate.of(2023, 9, 25)));
    sourcePoints.add(new SourcePoint(32.0d, LocalDate.of(2023, 9, 26)));
    sourcePoints.add(new SourcePoint(34.0d, LocalDate.of(2023, 9, 27)));
    sourcePoints.add(new SourcePoint(36.0d, LocalDate.of(2023, 9, 28)));
    sourcePoints.add(new SourcePoint(38.0d, LocalDate.of(2023, 9, 29)));
    mockSrcMAp.put("00005", sourcePoints);
  }

  // @Test
  void testConstructor() {
    try (MockedStatic<SourcePoint> mockedSP = mockStatic(SourcePoint.class)) {
      mockedSP.when(() -> SourcePoint.getSourceMap().get("00010"))//
          .thenReturn(mockSrcMAp.get("00005"));
      assertThat(SourcePoint.getSourceMap().get("00010"),
          hasItem(hasProperty("closePrice", equalTo(new Price(32.0d)))));
      assertThat(SourcePoint.getSourceMap().get("00010"),
          not(hasItem(hasProperty("closePrice", equalTo(new Price(40.0d))))));
    }
  }

  // @Test
  // public void testMovingAverageA() {
  //   Line line = new Line("AAPL", Interval.MONTH);
  //   int noOfInterval = 5;
  //   List<Point> movingAverage = line.movingAverageA(noOfInterval);
  //   movingAverage.add(noOfInterval,
  //       new Point(18.80, new TranDayTime(LocalDateTime)));
  //   assertEquals(noOfInterval - 1, movingAverage.size());
  // }
}
