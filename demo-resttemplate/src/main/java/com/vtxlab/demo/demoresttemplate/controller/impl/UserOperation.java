package com.vtxlab.demo.demoresttemplate.controller.impl;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.vtxlab.demo.demoresttemplate.model.User;
import infra.ApiResponse;

public interface UserOperation {


  @GetMapping(value = "/users")
  List<User> getAllUsers();

  @GetMapping(value = "/user/{id}")
  ResponseEntity<ApiResponse<User>> getUser(@PathVariable(value = "id") String id);

}
