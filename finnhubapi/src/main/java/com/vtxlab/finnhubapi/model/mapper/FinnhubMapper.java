package com.vtxlab.finnhubapi.model.mapper;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vtxlab.finnhubapi.model.CompanyProfile;
import com.vtxlab.finnhubapi.model.Quote;
import com.vtxlab.finnhubapi.model.dto.CompanyProfileDTO;
import com.vtxlab.finnhubapi.model.dto.StockDTO;

@Component
public class FinnhubMapper {

  @Autowired
  private ModelMapper modelMapper;


  public StockDTO map(CompanyProfile companyProfile, Quote quote) {
    return StockDTO.builder() //
        .symbol(companyProfile.getTicker())//
        .companyProfile(
            modelMapper.map(companyProfile, CompanyProfileDTO.class)) //
        .currentPrice(quote.getCurrentPrice()) //
        .dayHigh(quote.getDayHigh()) //
        .dayLow(quote.getDayLow()) //
        .dayOpen(quote.getDayOpen()) //
        .prevDayClose(quote.getPrevDayClose()) //
        .build();
  }


  // public StockSymbol map(Symbol symbol) {
  // return StockSymbol.builder()//
  // .symbol(symbol.getSymbol())//
  // .build();
  // }

  // public Stock map(CompanyProfile companyProfile) {
  // return Stock.builder()//
  // .country(companyProfile.getCountry())//
  // .companyName(companyProfile.getCompanyName())//
  // .logo(companyProfile.getLogo())//
  // .marketCap(companyProfile.getMarketCap())//
  // .currency(companyProfile.getCurrency())//
  // .build();
  // }

  // public StockPrice map(Quote quote) {
  // return StockPrice.builder()//
  // .currentPrice(quote.getCurrentPrice())//
  // .dayHigh(quote.getDayHigh())//
  // .dayLow(quote.getDayLow())//
  // .dayLow(quote.getDayLow())//
  // .dayOpen(quote.getDayOpen())//
  // .prevDayClose(quote.getPrevDayClose())//
  // .build();
  // }

  // public List<StockGetFromDBDTO> map(List<Stock> stocks,
  // List<StockPrice> stockPrices) {
  // List<StockGetFromDBDTO> result = new ArrayList<>();
  // for (int i = 0; i < stocks.size(); i++) {
  // StockGetFromDBDTO dto = new StockGetFromDBDTO();
  // dto.setStock(stocks.get(i));//
  // dto.setStockPrice(stockPrices.get(i));
  // result.add(dto);
  // }
  // return result;
  // StockGetFromDBDTO[].builder()//
  // .stock(modelMapper.map(stockPrices, Stock[].class))//
  // .stockPrice(modelMapper.map(stockPrices, StockPrice[].class))//
  // .build();
  // }

}
