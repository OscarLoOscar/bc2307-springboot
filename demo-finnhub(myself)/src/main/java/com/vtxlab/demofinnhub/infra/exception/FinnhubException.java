package com.vtxlab.demofinnhub.infra.exception;

import lombok.AllArgsConstructor;

public class FinnhubException extends BusinessException {
  public FinnhubException(BizCode code) {
    super(code);
  }

}
