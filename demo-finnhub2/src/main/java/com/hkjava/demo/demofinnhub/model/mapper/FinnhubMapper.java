package com.hkjava.demo.demofinnhub.model.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.entity.StockSymbolEntity;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;
import com.hkjava.demo.demofinnhub.model.Quote;
import com.hkjava.demo.demofinnhub.model.StockSymbol;
import com.hkjava.demo.demofinnhub.model.dto.CompanyProfileDTO;
import com.hkjava.demo.demofinnhub.model.dto.StockDTO;

@Component
public class FinnhubMapper {

  @Autowired
  private ModelMapper modelMapper;

  public StockDTO map(CompanyProfile companyProfile, Quote quote) {
    return StockDTO.builder() //
        .companyProfile(
            modelMapper.map(companyProfile, CompanyProfileDTO.class)) //
        .currentPrice(quote.getCurrentPrice()) //
        .dayHigh(quote.getDayHigh()) //
        .dayLow(quote.getDayLow()) //
        .dayOpen(quote.getDayOpen()) //
        .prevDayClose(quote.getPrevDayClose()) //
        .build();
  }

  public StockSymbolEntity map(StockSymbol stockSymbol) {
    return StockSymbolEntity.builder()//
        .symbol(stockSymbol.getSymbol())//
        .build();
  }

  public Stock map(CompanyProfile companyProfile) {
    return Stock.builder()//
        .country(companyProfile.getCountry())//
        .companyName(companyProfile.getCompanyName())//
        .logo(companyProfile.getLogo())//
        .marketCap(companyProfile.getMarketCap())//
        .currency(companyProfile.getCurrency())//
        .build();
  }

  public StockPrice map(Quote quote) {
    return StockPrice.builder()//
        .currentPrice(quote.getCurrentPrice())//
        .dayHigh(quote.getDayHigh())//
        .dayLow(quote.getDayLow())//
        .dayLow(quote.getDayLow())//
        .dayOpen(quote.getDayOpen())//
        .prevDayClose(quote.getPrevDayClose())//
        .build();
  }


}
