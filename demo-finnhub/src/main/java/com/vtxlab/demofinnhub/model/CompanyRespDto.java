package com.vtxlab.demofinnhub.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyRespDto {


  private String country;
  private String currency;
  private String estimateCurrency;
  private String exchange;
  private String finnhubIndustry;
  private long marketCapitalization;
  private String name;
  private String phone;
  private double shareOutstanding;
  private String ticker;

}
