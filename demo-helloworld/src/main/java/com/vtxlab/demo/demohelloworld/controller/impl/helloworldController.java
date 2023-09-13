package com.vtxlab.demo.demohelloworld.controller.impl;

import org.springframework.web.bind.annotation.GetMapping;

public interface helloworldController {
  
  @GetMapping(value = "/hello")
  public String hello();

}
