package com.vtxlab.admin.model.dto.Response;

import com.vtxlab.admin.entity.Stock;
import com.vtxlab.admin.entity.StockPrice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockGetFromDBDTO {
  public Stock stock;
  public StockPrice stockPrice;

}
