package com.vtxlab.democalculater.config;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCreator {

  @Bean(name = "arraylist") // give the bean a name , ,for autowird to use 
  public List<String> createArrayList() {
    List<String> strings = new ArrayList<>();
    strings.add("abc");
    strings.add("cde");
    strings.add("fgh");
    return strings;
  }

  @Bean(name = "linkedlist")
    public List<String> createLinkedList(){
      return new LinkedList<>();
    }

}
