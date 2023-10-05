package com.hkjava.demo.demofinnhub.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hkjava.demo.demofinnhub.entity.Stock;
import com.hkjava.demo.demofinnhub.entity.StockPrice;
import com.hkjava.demo.demofinnhub.exception.FinnhubException;
import com.hkjava.demo.demofinnhub.infra.Code;
import com.hkjava.demo.demofinnhub.infra.Protocol;
import com.hkjava.demo.demofinnhub.infra.RedisHelper;
import com.hkjava.demo.demofinnhub.model.APImodel.CompanyProfile2DTO;
import com.hkjava.demo.demofinnhub.model.APImodel.Quote;
import com.hkjava.demo.demofinnhub.model.mapper.FinnhubMapper;
import com.hkjava.demo.demofinnhub.repository.StockPriceRepository;
import com.hkjava.demo.demofinnhub.repository.StockRepository;
import com.hkjava.demo.demofinnhub.repository.SymbolRepository;
import com.hkjava.demo.demofinnhub.service.CompanyService;
import com.hkjava.demo.demofinnhub.service.StockPriceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  StockRepository stockRepository;

  @Autowired
  StockPriceRepository stockPriceRepository;

  @Autowired
  SymbolRepository symbolRepository;

  @Autowired
  StockPriceService stockPriceService;

  @Autowired
  FinnhubMapper finnhubMapper;

  @Autowired
  private RedisHelper redisHelper;

  @Autowired
  private ObjectMapper redisObjectMapper;


  @Autowired
  @Qualifier(value = "finnhubToken")
  private String token;

  @Value(value = "${api.finnhub.domain}")
  private String domain;

  @Value(value = "${api.finnhub.base-url}")
  private String baseUrl;

  @Value(value = "${api.finnhub.endpoints.stock.profile2}")
  private String companyProfile2Endpoint;

  @Value(value = "${redis-key.company-profile2}")
  private String redisKeyForProfile2;

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
  public CompanyProfile2DTO getCompanyProfile(String symbol)
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
    return restTemplate.getForObject(url, CompanyProfile2DTO.class);
    // } catch (RestClientException e) {
    // throw new FinnhubException(Code.FINNHUB_PROFILE2_NOTFOUND);
    // }
  }

  @Override
  public void refresh() throws FinnhubException {
    // Target :
    // getCompanyProfile(String symbol)
    symbolRepository.findAll().stream()//
        .forEach(symbol -> {
          try {
            // Get Company Profile 2 (New) and insert into database
            CompanyProfile2DTO newProfile =
                this.getCompanyProfile(symbol.getSymbol());
            // Old Stock
            Optional<Stock> oldStock =
                stockRepository.findByStockSymbol(symbol);
            // id & symbol no change
            if (oldStock.isPresent()) {
              Stock stock = oldStock.get();
              stock.setCountry(newProfile.getCountry());
              stock.setCompanyName(newProfile.getCompanyName());
              stock.setCurrency(newProfile.getCurrency());
              stock.setMarketCap(newProfile.getMarketCap());
              stock.setLogo(newProfile.getLogo());

              if (newProfile != null
                  && newProfile.getTicker().equals(symbol.getSymbol())) {
                log.info("newProfile.getTicker() : " + newProfile.getTicker());
                stock.setStockStatus('A');
              } else {
                stock.setStockStatus('I');
              }
              stockRepository.save(stock);
              log.info("complete symbol = " + symbol.getSymbol());
              // Get stock price and save a new record of price in to DB
              Quote quote = stockPriceService.getQuote(symbol.getSymbol());
              StockPrice stockPrice = finnhubMapper.map(quote);
              stockPrice.setStock(stock);
              stockPriceRepository.save(stockPrice);
              log.info("complete symbol = " + symbol.getSymbol());
            } else {
              System.out.println(symbol.getSymbol() + "is NOT FOUND");
            }
          } catch (FinnhubException e) {
            log.info("RestClientException : Symbol " + symbol.getSymbol());
          }
        });
    // if normal response , findBySymbol
    // if abnormal response , patch Entity status to 'I'
    // CompanyProfile conventData = this.getCompanyProfile(symbol);
    // if (!conventData.getTicker().equals(symbol))
    // return null;
    // return conventData;

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

  @Override
  public List<Stock> findByCountryAndMarketCap(String country,
      double marketCap) {
    return stockRepository
        .findFirst3ByCountryAndMarketCapGreaterThanEqualOrderByIdDesc(country,
            marketCap);
  }


  @Override
  public CompanyProfile2DTO getCompanyProfileSaveInRedis(String symbol) throws FinnhubException{
String url = UriComponentsBuilder.newInstance()//
.scheme(Protocol.HTTPS.name().toLowerCase())//
.host(domain)//
.pathSegment(baseUrl)//
.path(companyProfile2Endpoint)//
.queryParam("symbol", symbol)//
.queryParam("token", token)//
.build()//
.toUriString();
String key = RedisHelper.formatKey(redisKeyForProfile2, symbol);

//Invoke company Profile2 with Rredis Handling
try{
  CompanyProfile2DTO profile = 
  restTemplate.getForObject(url, CompanyProfile2DTO.class);//mocked
  if(Objects.nonNull(profile)){//success
redisHelper.set(key, profile, 600000000);
  }else{//fail , get from redis
profile = (CompanyProfile2DTO)redisHelper.get(key);
if(profile ==null)
throw new FinnhubException(Code.FINNHUB_PROFILE2_NOTFOUND);
  }
  return profile;
}catch (RestClientException e){
  CompanyProfile2DTO profileFromRedis = (CompanyProfile2DTO)redisHelper.get(key);
  if(profileFromRedis == null)
  throw new FinnhubException(Code.FINNHUB_PROFILE2_NOTFOUND);
  return profileFromRedis;
}
  }
}
