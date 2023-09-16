package com.vtxlab.demo.demoresttemplate.controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.vtxlab.demo.demoresttemplate.model.Post;

public interface PostOperation {
  @GetMapping(value = "/user/{id}/posts")
  List<Post> getAllPostByUserId(@PathVariable(value = "id") int userId);

  @GetMapping(value = "/posts")
  List<Post> getAllPost();

  @GetMapping(value = "/post/{id}")
  Post getAPostBypostId(@PathVariable(value = "id") int postId);

}
