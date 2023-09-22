package com.hkjava.demo.demofinnhub.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.hkjava.demo.demofinnhub.entity.Stock;

public interface DataOperation {

  @PostMapping(value = "/data/stock")
  @ResponseStatus(value = HttpStatus.OK)
  Stock save(@RequestBody Stock stock);

  @GetMapping(value = "/data/stocks")
  @ResponseStatus(value = HttpStatus.OK)
  List<Stock> findAll();

  @GetMapping(value = "/data/stock/country/{country}")
  @ResponseStatus(value = HttpStatus.OK)
  List<Stock> findByCountry(@PathVariable String country);

  @GetMapping(value = "/data/stock/id2/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  List<Stock> findAllById2(@PathVariable String id);

  @GetMapping(value = "/data/stock/id3/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  Stock findAllById3(@PathVariable String id);

  @DeleteMapping(value = "/data/stock/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  void deleteById(@PathVariable Long id);

  @PutMapping(value = "/data/stock/{id}")
  @ResponseStatus(value = HttpStatus.OK)
  void updateById(@PathVariable Long id, @RequestBody Stock stock);

  @PatchMapping(value = "/data/stock/id/{id}/companyname/{companyName}")
  @ResponseStatus(value = HttpStatus.OK)
  void updateCompanyNameById(@PathVariable Long id,
      @PathVariable String companyName);

}
