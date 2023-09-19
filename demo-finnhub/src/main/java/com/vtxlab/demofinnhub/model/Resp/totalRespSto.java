package com.vtxlab.demofinnhub.model.Resp;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vtxlab.demofinnhub.model.CompanyReqDto;
import com.vtxlab.demofinnhub.model.quoteReqDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class totalRespSto {

  private CompanyProfile companyProfile;

  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class CompanyProfile {
    private String country;
    private String name;
    private String ipo;
    private String logo;
    private long marketCapitalization;
    private String currency;
  }

  private double currentPrice;
  private double dayHigh;
  private double dayLow;
  private double dayOpen;
  private double prevDayClose;
}

