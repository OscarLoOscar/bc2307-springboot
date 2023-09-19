package com.vtxlab.demofinnhub.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.demofinnhub.infra.ApiResponse;

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


  @ExceptionHandler(value = invalidInputException.class) // 全局攔截，早過Controller get 野，有error先check，exception 存在優先check
  public ResponseEntity<ApiResponse<Void>> invalidInputExceptionHanlder() {

    ApiResponse<Void> response = ApiResponse.<Void>builder()//
        .status(BizCode.INVALID_INPUT)//
        .data(null)//
        .build();
    return ResponseEntity.badRequest().body(response);
  }

  @ExceptionHandler(value = urlNotFoundException.class) // 全局攔截，早過Controller get 野，有error先check，exception 存在優先check
  public ResponseEntity<ApiResponse<Void>> userNotFoundException() {

    ApiResponse<Void> response = ApiResponse.<Void>builder()//
        .status(BizCode.Url_NOT_FOUND)//
        .data(null)//
        .build();
    return ResponseEntity.badRequest().body(response);
  }

}
