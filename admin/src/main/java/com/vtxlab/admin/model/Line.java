// package com.vtxlab.admin.model;

// import java.math.BigDecimal;
// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.Comparator;
// import java.util.Deque;
// import java.util.LinkedList;
// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import com.hkjava.demo.demofinnhub.infra.Interval;
// import com.hkjava.demo.demofinnhub.repository.StockPriceRepository;

// public class Line {
//   // private String type : enum : DAY,WEEK,MONTH,HOUR,30_MINUTE
//   private Interval interval;

//   private String symbol;

//   private Deque<Point> closePoints; // per month


//   public Line(String symbol, Interval interval) {// DAY, WEEK, MONTH
//     this.interval = interval; // month
//     this.symbol = symbol;
//     this.closePoints = new LinkedList<>();
//     Comparator<SourcePoint> reversed =
//         (SourcePoint p1, SourcePoint p2) -> p1.getTranDayTime().getDatetime()
//             .isAfter(p2.getTranDayTime().getDatetime()) ? -1 : 1;
//     SourcePoint.sourceMap.get(symbol).stream()//
//         .filter(s -> {
//           if (interval == Interval.WEEK)
//             return s.getTranDayTime().isWeeklyClose();
//           else if (interval == Interval.MONTH)
//             return s.getTranDayTime().isMonthlyClose();
//           else // day
//             return true;
//         }).sorted(reversed)//
//         .forEach(s -> {
//           closePoints.add(s.toPoint());
//         });
//   }

//   // instance method -> calculate
// public List<Point> movingAverage(int noOfInterval){
//   List<Point> movingAveragePoints = new ArrayList<>();

//   //cal the moving average for each point in the line
//   for(int i = 0 ;i < closePoints.size() ; i++){
//     BigDecimal sum = BigDecimal.ZERO;
//     int count = 0;

//     //add the closing prices of the previous noOfInterval points to the sum
//     for(int j = i ; j > i - noOfInterval && j>=0 ; j--){
//       sum = sum.add(closePoints.pollFirst());
//       count++;
//     }
//     //cal the moving average by dividing the sum by the number of points
//   }
//   int count = 0;
//   BigDecimal first=
//   while(count < noOfInterval){
//     count++;
//   }
// }

//   // Override the Getter
//   public List<Point> getClosePoints() {
//     List<Point> points = new ArrayList<>();
//     points.addAll(this.closePoints);
//     return points;
//   }
// }

