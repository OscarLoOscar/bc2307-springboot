package com.vtxlab.demofinnhub.infra.exception;

import lombok.NoArgsConstructor;

public class invalidInputException extends BusinessException {
  public invalidInputException(BizCode code) {
    super(code);
  }
}
