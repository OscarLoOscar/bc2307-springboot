package com.example.demo.demostockexchange.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@AllArgsConstructor
@Getter
@ToString
@Setter
@Component
public class OrderRequest {
  String type; // 'BUY','SELL'

  @JsonFormat(locale = "zh", timezone = "GMT+8",
      pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat
  @Column(name = "placedAt")
  private LocalDate tradeDate = LocalDate.now();

  Long stockId;

  Double price;

  private Integer quantity;

}
