package com.hkjava.demo.demofinnhub.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockSymbol {
  public String currency;
  public String description;
  public String displaySymbol;
  public String figi;
  public String isin;
  public String mic;
  public String shareClassFIGI;
  public String symbol;
  public String symbol2;
  public String type;
}
