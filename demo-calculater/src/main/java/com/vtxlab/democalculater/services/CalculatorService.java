package com.vtxlab.democalculater.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.vtxlab.democalculater.services.impl.CalculatorServiceImpl;

@Service
public class CalculatorService implements CalculatorServiceImpl {

  @Autowired
  @Qualifier(value = "arraylist")
  List<String> strings;

  @Override
  public int add(int x, int y, String z, int k) {
    return x + y;
  }

  @Override
  public int subStract(int x, int y) {
    return x - y;
  }

  @Override
  public List<String> getStrings() {
    // new ArrayList<>();
    return strings;
  }
}

