package com.vtxlab.demo.demoresttemplate.controller.impl;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.vtxlab.demo.demoresttemplate.infra.ApiResponse;
import com.vtxlab.demo.demoresttemplate.infra.exception.BusinessException;
import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.model.DTO.UserDto;

public interface UserOperation {


  @GetMapping(value = "/users")
  ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers()
      throws BusinessException;

  @GetMapping(value = "/user/{id}")
  ResponseEntity<ApiResponse<User>> getUser(
      @PathVariable(value = "id") String id)throws BusinessException ;

}
