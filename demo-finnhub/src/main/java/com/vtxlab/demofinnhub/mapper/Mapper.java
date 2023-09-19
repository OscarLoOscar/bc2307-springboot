package com.vtxlab.demofinnhub.mapper;

import com.vtxlab.demofinnhub.model.CompanyReqDto;
import com.vtxlab.demofinnhub.model.quoteReqDto;
import com.vtxlab.demofinnhub.model.Resp.totalRespSto;
import com.vtxlab.demofinnhub.model.Resp.totalRespSto.CompanyProfile;

public class Mapper {
  public static totalRespSto map(CompanyReqDto CompanyReqDto,
      quoteReqDto quote) {
    return totalRespSto.builder()//
        .companyProfile(//
            totalRespSto.CompanyProfile.builder()//
                .country(CompanyReqDto.getCountry())//
                .name(CompanyReqDto.getName())//
                .ipo(CompanyReqDto.getIpo())//
                .logo(CompanyReqDto.getLogo())//
                .marketCapitalization(
                    CompanyReqDto.getMarketCapitalization())//
                .currency(CompanyReqDto.getCurrency())//
                .build())//
        .currentPrice(quote.c)//
        .dayHigh(quote.d)//
        .dayLow(quote.dp)//
        .dayOpen(quote.o)//
        .prevDayClose(quote.pc)//
        .build();//



  }
}
