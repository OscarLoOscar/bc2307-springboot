package com.vtxlab.demo.demoresttemplate.infra.exception;

public class invalidInputException extends BusinessException {
  public invalidInputException(BizCode code) {
    super(code);
  }
}
