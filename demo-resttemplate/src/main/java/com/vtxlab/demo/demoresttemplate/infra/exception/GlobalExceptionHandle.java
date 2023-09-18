package com.vtxlab.demo.demoresttemplate.infra.exception;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.demo.demoresttemplate.infra.ApiResponse;
import com.vtxlab.demo.demoresttemplate.model.DTO.UserDto;

@RestControllerAdvice // @ResponseBody + @ ControllerAdvice
public class GlobalExceptionHandle {

  @ExceptionHandler(value = JPHException.class) // 全局攔截，早過Controller get 野，有error先check，exception 存在優先check
  public ResponseEntity<ApiResponse<Void>> getUserExceptionHanlder() {

    ApiResponse<Void> response = ApiResponse.<Void>builder()//
        .status(BizCode.RESOURCE_NOT_FOUND)//
        .data(null)//
        .build();
    return ResponseEntity.badRequest().body(response);
  }
}
