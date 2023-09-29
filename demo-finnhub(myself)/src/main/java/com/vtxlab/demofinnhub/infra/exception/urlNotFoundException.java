package com.vtxlab.demofinnhub.infra.exception;

public class urlNotFoundException extends BusinessException {
  public urlNotFoundException(BizCode code) {
    super(code);
  }
}
