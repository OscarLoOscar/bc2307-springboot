package com.vtxlab.democalculater.controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

public interface BeanDisplaylayer {
  @GetMapping(value = "/getbeans")
  List<String> getAllBeans();

}
