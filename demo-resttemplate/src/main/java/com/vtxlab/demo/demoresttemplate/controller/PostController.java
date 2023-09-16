package com.vtxlab.demo.demoresttemplate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.demoresttemplate.controller.impl.PostOperation;
import com.vtxlab.demo.demoresttemplate.model.Post;
import com.vtxlab.demo.demoresttemplate.services.PostService;

@RestController
@RequestMapping(value = "/api/v1")
public class PostController implements PostOperation {


  @Autowired
  PostService postService;

  @Override
  public List<Post> getAllPostByUserId(int userId) {
    return postService.getAllPostByUserId(userId);
  }

  @Override
  public List<Post> getAllPost() {
    return postService.getAllPost();
  }

  @Override
  public Post getAPostBypostId(int postId) {
    return postService.getAPostBypostId(postId);
  }

}
