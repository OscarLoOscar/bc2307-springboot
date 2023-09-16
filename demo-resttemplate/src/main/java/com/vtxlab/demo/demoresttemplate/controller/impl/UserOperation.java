package com.vtxlab.demo.demoresttemplate.controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.vtxlab.demo.demoresttemplate.model.User;

public interface UserOperation {


  @GetMapping(value = "/users")
  List<User> getAllUsers();

  @GetMapping(value = "/user/{id}")
  User getUser(@PathVariable(value = "id") int id);

}
