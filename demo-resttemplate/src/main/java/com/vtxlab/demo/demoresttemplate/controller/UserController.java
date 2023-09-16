package com.vtxlab.demo.demoresttemplate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.demoresttemplate.controller.impl.UserOperation;
import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.services.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController implements UserOperation {

  @Autowired
  UserService userService;

  @Override
  public List<User> getAllUsers() {
    return userService.findAllUsers();//
  }

  @Override
  public User getUser(int id) {
    return userService.findUser(id);
  }

}
