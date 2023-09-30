package com.example.demo.demostockexchange.model;

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
public class OrderResp {
  String type; // 'Bid','Ask'

  String stockId;

  Double price;

  private Integer quantity;

}
