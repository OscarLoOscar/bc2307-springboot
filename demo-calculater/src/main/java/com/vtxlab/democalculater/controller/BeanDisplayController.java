package com.vtxlab.democalculater.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.democalculater.DemoCalculaterApplication;
import com.vtxlab.democalculater.controller.impl.BeanDisplaylayer;

@RestController
@RequestMapping(value = "/api/v1")
public class BeanDisplayController implements BeanDisplaylayer {

  @Autowired
  DemoCalculaterApplication app;


  @Override
  public List<String> getAllBeans() {
    return Arrays.asList(app.getBean());
  }

}
