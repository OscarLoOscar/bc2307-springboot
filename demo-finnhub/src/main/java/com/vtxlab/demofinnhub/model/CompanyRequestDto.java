package com.vtxlab.demofinnhub.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
@NoArgsConstructor
@Getter
// @Builder
public class CompanyRequestDto {
  // private List<companyProfile> companyProfile;

  // public static CompanyRequestDto.companyProfile emptyCompanyProfile() {
  // return new CompanyRequestDto().new companyProfile();
  // }

  // @Data
  // @AllArgsConstructor
  // @NoArgsConstructor
  // public class companyProfile {
  private String country;
  private String currency;
  //private String estimateCurrency;
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
  // }
}
