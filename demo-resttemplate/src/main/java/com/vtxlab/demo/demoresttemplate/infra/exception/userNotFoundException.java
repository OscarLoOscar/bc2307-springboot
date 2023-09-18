package com.vtxlab.demo.demoresttemplate.infra.exception;

public class userNotFoundException extends BusinessException {
  public userNotFoundException(BizCode code) {
    super(code);
  }
}
