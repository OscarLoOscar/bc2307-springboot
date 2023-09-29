package com.vtxlab.admin.annotation;

import java.util.Objects;
import com.vtxlab.admin.config.AppStartRunner;
import com.vtxlab.admin.model.dto.Request.SymbolReqDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SymbolValidator
    implements ConstraintValidator<SymbolCheck, SymbolReqDTO> {

  @Override
  public boolean isValid(SymbolReqDTO symbol, ConstraintValidatorContext context) {
    return Objects.nonNull(symbol.getSymbol())
        && AppStartRunner.availableStockList.contains(symbol.getSymbol());
  }

}
