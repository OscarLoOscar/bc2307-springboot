package com.vtxlab.democalculater.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.democalculater.controller.impl.CalculatorOperation;
import com.vtxlab.democalculater.services.CalculatorService;
import com.vtxlab.democalculater.services.impl.CalculatorServiceImpl;

// @Controller
// @ResponseBody
@RestController
@RequestMapping(value = "/api/v1")
public class CalculatorController implements CalculatorOperation {
  @Autowired
  CalculatorService calculatorService;

  @Override
  public Integer add(int salary, int bonus, String dividend, int k) {
    int d;
    try {
      d = Integer.valueOf(dividend);
    } catch (NumberFormatException e) {
      d = 0;
    }
    return calculatorService.add(salary, bonus, dividend, k);
  }

  @Override
  public Integer subStract(int salary, int y, int z) {
    return calculatorService.subStract(salary - y, z);
  }

  @Override
  public List<String> getStrings() {
    return calculatorService.getStrings();
  }
}
