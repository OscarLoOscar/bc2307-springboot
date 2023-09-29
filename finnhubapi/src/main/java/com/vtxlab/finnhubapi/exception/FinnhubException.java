package com.vtxlab.finnhubapi.exception;

import com.vtxlab.finnhubapi.infra.BusinessException;
import com.vtxlab.finnhubapi.infra.Code;

public class FinnhubException extends BusinessException {

  public FinnhubException(Code code) {
    super(code);
  }

}
