package com.hkjava.demo.demofinnhub.service.callAPI.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.Protocol;
import com.hkjava.demo.demofinnhub.model.CompanyProfile;
import com.hkjava.demo.demofinnhub.model.mapper.FinnhubMapper;
import com.hkjava.demo.demofinnhub.repository.StockPriceRepository;
import com.hkjava.demo.demofinnhub.repository.StockRepository;
import com.hkjava.demo.demofinnhub.service.callAPI.CompanyService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CompanyServiceImpl implements CompanyService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  StockRepository stockRepository;

  @Autowired
  StockPriceRepository stockPriceRepository;

  @Autowired
  FinnhubMapper finnhubMapper;

  @Autowired
  @Qualifier(value = "finnhubToken")
  private String token;

  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.base-url}")
  private String baseUrl;

  @Value(value = "${api.finnhub.endpoints.stock.profile2}")
  private String companyProfile2Endpoint;

  @Override
  public List<Stock> findAll() {
    return stockRepository.findAll();
  }

  @Override
  public void updateById(Long id, Stock newStock) {
    Stock stock = stockRepository.findById(id) //
        .orElseThrow(
            () -> new EntityNotFoundException("Entity Stock ID not Found"));
    stock.setCompanyName(newStock.getCompanyName());
    stock.setCountry(newStock.getCountry());
    stock.setIpoDate(newStock.getIpoDate());
    stock.setMarketCap(newStock.getMarketCap());
    stock.setCurrency(newStock.getCurrency());
    stock.setLogo(newStock.getLogo());
    stockRepository.save(stock);
  }

  @Override
  public void updateCompanyNameById(Long id, String companyName) {
    Stock stock = stockRepository.findById(id) //
        .orElseThrow(
            () -> new EntityNotFoundException("Entity Stock ID not Found"));
    stock.setCompanyName(companyName);
    stockRepository.save(stock);
  }

  @Override
  public Stock save(Stock stock) {
    return stockRepository.save(stock); // insert into
  }

  @Override
  public void deleteById(Long id) {
    stockRepository.deleteById(id); // delete from table where id = ?
  }

  @Override
  public CompanyProfile getCompanyProfile(String symbol)
      throws FinnhubException {
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Protocol.HTTPS.name()) //
        .host(domain) //
        .pathSegment(baseUrl) //
        .path(companyProfile2Endpoint) //
        .queryParam("symbol", symbol) //
        .queryParam("token", token) //
        .build() //
        .toUriString();
    System.out.println("url = " + url);
    // try {
    return restTemplate.getForObject(url, CompanyProfile.class);
    // } catch (RestClientException e) {
    // throw new FinnhubException(Code.FINNHUB_PROFILE2_NOTFOUND);
    // }
  }

  @Override
  public List<Stock> findByCountry(String country) {
    return stockRepository.findByCountry(country);
  }

  @Override
  public List<Stock> findAllById2(Long id) {
    return stockRepository.findAllById2(id);
  }

  @Override
  public Stock findAllById3(Long id) {
    return stockRepository.findAllById3(id);
  }

  @Override
  public void deleteAll() {
    stockRepository.deleteAll();
  }



}
