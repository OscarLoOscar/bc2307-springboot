package com.vtxlab.admin.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Point {

  private Price closePrice;

  private TranDayTime tranDateTime;

}
