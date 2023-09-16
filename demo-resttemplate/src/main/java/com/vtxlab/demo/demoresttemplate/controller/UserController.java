package com.vtxlab.demo.demoresttemplate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.demoresttemplate.controller.impl.UserOperation;
import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.services.UserService;
import infra.ApiResponse;
import infra.exception.BizCode;
import infra.exception.BusinessException;

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
  public ResponseEntity<ApiResponse<User>> getUser(String id) {
    try {
      int userId = Integer.parseInt(id);
      User user = userService.findUser(userId);

      ApiResponse<User> response = ApiResponse.<User>builder()//
          .ok()//
          .data(user)//
          .build();
      return ResponseEntity.ok(response);

    } catch (NumberFormatException e) {
      String errorMessage = "Please input a valid number.";
      ApiResponse<User> output = ApiResponse.<User>builder()//
          .error(BusinessException.of(//
              BizCode.RESOURCE_NOT_FOUND.getCode(), //
              errorMessage))//
          .build();
      return ResponseEntity.badRequest().body(output);
    }

  }
}
