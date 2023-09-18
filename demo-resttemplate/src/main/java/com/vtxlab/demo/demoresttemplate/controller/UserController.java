package com.vtxlab.demo.demoresttemplate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
      // success case
      if (user != null) {
        ApiResponse<User> checked = ApiResponse.<User>builder()//
            .ok()//
            .data(user)//
            .build();
        return ResponseEntity.ok(checked);
      } else {
        // handle no userId
        ApiResponse<User> idNotFound = ApiResponse.<User>builder()//
            .error(BusinessException.of(//
                BizCode.USER_NOT_FOUND.getCode(), //
                BizCode.USER_NOT_FOUND.getMessage() + id))//
            .build();
        return ResponseEntity.badRequest().body(idNotFound);

      }
    } catch (NumberFormatException e) {
      // handle isLetter
      ApiResponse<User> inValidInput = ApiResponse.<User>builder()//
          .error(BusinessException.of(//
              BizCode.INVALID_INPUT.getCode(), //
              BizCode.INVALID_INPUT.getMessage() + id))//
          .build();
      return ResponseEntity.badRequest().body(inValidInput);
    }

  }
}
