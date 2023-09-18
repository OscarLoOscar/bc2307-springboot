package com.vtxlab.demo.demoresttemplate.controller.impl;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.vtxlab.demo.demoresttemplate.infra.ApiResponse;
import com.vtxlab.demo.demoresttemplate.model.Post;

public interface PostOperation {
  @GetMapping(value = "/user/{id}/posts")
  ResponseEntity<ApiResponse<List<Post>>> getAllPostByUserId(@PathVariable(value = "id") String userId);

  @GetMapping(value = "/posts")
  List<Post> getAllPost();

  @GetMapping(value = "/post/{id}")
  ResponseEntity<ApiResponse<Post>> getAPostBypostId(@PathVariable(value = "id") String postId);

}
