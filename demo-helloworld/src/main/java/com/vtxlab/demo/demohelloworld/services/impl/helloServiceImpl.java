package com.vtxlab.demo.demohelloworld.services.impl;

import org.springframework.stereotype.Service;

import com.vtxlab.demo.demohelloworld.services.helloService;

@Service
public class helloServiceImpl implements helloService {

  @Override
  public String generate(int x) {
    if (x > 100)
      return "hello world";
    return "ABC";
  }

}
