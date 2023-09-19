package com.vtxlab.demofinnhub.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
public class CompanyRequestDto {
  private String country;
  private String currency;
  private String exchange;
  private String finnhubIndustry;
  private String ipo;
  private String logo;
  private long marketCapitalization;
  private String name;
  private String phone;
  private double shareOutstanding;
  private String ticker;
  private String weburl;
}
