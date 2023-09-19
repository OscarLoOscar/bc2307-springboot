package com.vtxlab.demofinnhub.mapper;

import com.vtxlab.demofinnhub.model.CompanyRequestDto;
import com.vtxlab.demofinnhub.model.quoteReqDto;
import com.vtxlab.demofinnhub.model.Resp.totalRespSto;
import com.vtxlab.demofinnhub.model.Resp.totalRespSto.CompanyProfile;

public class Mapper {
  public static totalRespSto map(CompanyRequestDto companyRequestDto,
      quoteReqDto quote) {
    return totalRespSto.builder()//
        .companyProfile(//
            totalRespSto.CompanyProfile.builder()//
                .country(companyRequestDto.getCountry())//
                .name(companyRequestDto.getName())//
                .ipo(companyRequestDto.getIpo())//
                .logo(companyRequestDto.getLogo())//
                .marketCapitalization(
                    companyRequestDto.getMarketCapitalization())//
                .currency(companyRequestDto.getCurrency())//
                .build())//
        .currentPrice(quote.c)//
        .dayHigh(quote.d)//
        .dayLow(quote.dp)//
        .dayOpen(quote.o)//
        .prevDayClose(quote.pc)//
        .build();//



  }
}
