package com.vtxlab.admin.model.dto.Request;

import com.vtxlab.admin.annotation.SymbolCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class SymbolReqDTO {
  @SymbolCheck
  String symbol;

}
