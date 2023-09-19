package com.vtxlab.demofinnhub.infra.exception;

public class FinnhubException extends BusinessException {
  public FinnhubException(BizCode code) {
    super(code);
  }
}
