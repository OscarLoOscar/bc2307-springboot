package com.vtxlab.demo.demohelloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtxlab.demo.demohelloworld.controller.impl.helloworldController;
import com.vtxlab.demo.demohelloworld.services.impl.helloServiceImpl;

@Controller
// @Component 含糊
// @Configuration
// @EnableAutoConfiguration
// @ComponentScan(most important)
@ResponseBody
@RequestMapping(value = "/api/v1")
public class helloworldControllerImpl implements helloworldController {

  @Autowired
  helloServiceImpl helloServiceImpl;

  public String hello() {
    return helloServiceImpl.generate(102);
  }
}
