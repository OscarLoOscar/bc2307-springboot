package com.vtxlab.demo.demoresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
  Long postId;
  Long id;
  String name;
  String email;
  String body;
}
