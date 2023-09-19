package com.vtxlab.demofinnhub.infra.exception;

public class invalidInputException extends BusinessException {
  public invalidInputException(BizCode code) {
    super(code);
  }
}
