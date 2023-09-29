package com.vtxlab.admin.exception;

import com.vtxlab.admin.infra.BusinessException;
import com.vtxlab.admin.infra.Code;

public class FinnhubException extends BusinessException {

  public FinnhubException(Code code) {
    super(code);
  }

}
