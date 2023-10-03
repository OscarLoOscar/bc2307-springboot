package com.hkjava.demo.demofinnhub;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.math.BigDecimal;
import java.util.Deque;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.hkjava.demo.demofinnhub.infra.Interval;
import com.hkjava.demo.demofinnhub.model.Line;
import com.hkjava.demo.demofinnhub.model.Point;

@SpringBootTest
public class testMVG {

  @Mock
  Deque<Point> closePoints;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testMVG() {
    List<Point> pointList = List.of(//
        new Point(BigDecimal.valueOf(10)), //
        new Point(BigDecimal.valueOf(20)), //
        new Point(BigDecimal.valueOf(30)), //
        new Point(BigDecimal.valueOf(40)), //
        new Point(BigDecimal.valueOf(50)));//

    when(closePoints.iterator()).thenReturn(pointList.iterator());

    Line newLine = new Line("TSLA", Interval.MIN_1);

    List<Point> movingAveragePoints = newLine.movingAverage(5);

    assertEquals(3, movingAveragePoints.size());
    assertEquals(BigDecimal.valueOf(20),
        movingAveragePoints.get(0).getClosePrice());
    assertEquals(BigDecimal.valueOf(30),
        movingAveragePoints.get(1).getClosePrice());
    assertEquals(BigDecimal.valueOf(40),
        movingAveragePoints.get(2).getClosePrice());
  }
}
