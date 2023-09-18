package com.vtxlab.demo.demoresttemplate.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.demoresttemplate.controller.impl.UserOperation;
import com.vtxlab.demo.demoresttemplate.infra.ApiResponse;
import com.vtxlab.demo.demoresttemplate.infra.exception.BizCode;
import com.vtxlab.demo.demoresttemplate.infra.exception.BusinessException;
import com.vtxlab.demo.demoresttemplate.mapper.userMapper;
import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.model.DTO.UserDto;
import com.vtxlab.demo.demoresttemplate.services.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController implements UserOperation {

  @Autowired
  UserService userService;

  @Override
  public ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers()throws BusinessException  {
    // Convension
    List<User> user = userService.findAllUsers();

    //可以skip
    if (user == null) {
      ApiResponse<List<UserDto>> badResponse =
          ApiResponse.<List<UserDto>>builder()//
              .ok()//
              .data(null)//
              .build();
      return ResponseEntity.badRequest().body(badResponse);
    }
    // List<UserDto> userDtos = user.stream()// NullPointer
    // .map(user -> userMapper.map(user))//
    // .collect(Collectors.toList());

    // Conversion user -> userDto ，核心code
    List<UserDto> userDtos = user.stream()//
        .map(e -> userMapper.map(e))//
        .collect(Collectors.toList());

    ApiResponse<List<UserDto>> response = ApiResponse.<List<UserDto>>builder() //
        .ok() //
        .data(userDtos) //
        .build();
    return ResponseEntity.ok().body(response);
    // return userDtos;//
  }

  @Override
  public ResponseEntity<ApiResponse<User>> getUser(String id)throws BusinessException {
    try {
      int userId = Integer.parseInt(id);
      User user = userService.findUser(userId);
      // Dto 係user 要咩field ，所以就user
      // 問JsonPlaceHolder 唔係為左服務人
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
