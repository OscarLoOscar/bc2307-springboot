package com.vtxlab.demofinnhub.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// @AllArgsConstructor
// @NoArgsConstructor
public class BusinessException extends Exception {
  private int code;

  public BusinessException(int code, String message) {
    super(message);
    this.code = code;
  }

  public BusinessException(BizCode code) {
    super(code.getMessage());
    this.code = code.getCode();
  }

  public BusinessException(int code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }

  public static BusinessException of(int code, String message) {
    return new BusinessException(code, message);
  }
}
