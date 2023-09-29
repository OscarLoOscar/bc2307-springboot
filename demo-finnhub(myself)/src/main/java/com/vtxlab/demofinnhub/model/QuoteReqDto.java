package com.vtxlab.demofinnhub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class QuoteReqDto {
  public double c;
  public double d;
  public double dp;
  public double h;
  public double l;
  public double o;
  public double pc;
  public int t;
}
