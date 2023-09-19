package com.vtxlab.demofinnhub.mapper;

import com.vtxlab.demofinnhub.model.CompanyRequestDto;
import com.vtxlab.demofinnhub.model.CompanyRespDto;

public class companyMapper {
  // public static CompanyRespDto map(
  // CompanyRequestDto companyProfileRequestDto) {
  // return CompanyRespDto.builder()//
  // .country(companyProfileRequestDto.getCompanyProfile().get(0))//
  // .currency(companyProfileRequestDto.getCompanyProfile().get(1))//
  // .estimateCurrency(companyProfileRequestDto.getCompanyProfile().get(2))//
  // .exchange(companyProfileRequestDto.getCompanyProfile().get(3))//
  // .finnhubIndustry(companyProfileRequestDto.getCompanyProfile().get(4))//
  // .marketCapitalization(
  // companyProfileRequestDto.getCompanyProfile().get(5))//
  // .name(companyProfileRequestDto.getCompanyProfile().get(6))//
  // .phone(companyProfileRequestDto.getCompanyProfile().get(7))//
  // .shareOutstanding(companyProfileRequestDto.getCompanyProfile().get(8))//
  // .ticker(companyProfileRequestDto.getCompanyProfile().get(9))//
  // .build();

  // }

  public static CompanyRespDto map(
      CompanyRequestDto companyProfileRequestDto) {
        return CompanyRespDto.builder()//
        .country(companyProfileRequestDto.getCountry())
        .currency(companyProfileRequestDto.getCurrency())//
        .exchange(companyProfileRequestDto.getExchange())//
        .finnhubIndustry(companyProfileRequestDto.getFinnhubIndustry())//
        .marketCapitalization(companyProfileRequestDto.getMarketCapitalization())//
        .name(companyProfileRequestDto.getName())//
        .phone(companyProfileRequestDto.getPhone())//
        .shareOutstanding(companyProfileRequestDto.getShareOutstanding())//
        .ticker(companyProfileRequestDto.getTicker())
        .build();
      }
}
