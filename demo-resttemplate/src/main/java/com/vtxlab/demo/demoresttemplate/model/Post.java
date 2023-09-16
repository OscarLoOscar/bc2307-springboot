package com.vtxlab.demo.demoresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Post {
  Long userId;
  Long id;
  String title;
  String body;
}
