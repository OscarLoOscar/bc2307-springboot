package com.vtxlab.demo.demoresttemplate.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
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
  public List<Post> getAllPostByUserId(String userId) {
    Optional<Integer> optionUserId = parseUserId(userId);
    if (optionUserId.isPresent()) {
      int userIdValue = optionUserId.get();
      List<Post> posts = postService.getAllPostByUserId(userIdValue);
      return posts;
    } else {
      // handle invalid user id
      return Collections.emptyList();
    }
  }

  @Override
  public List<Post> getAllPost() {
    return postService.getAllPost();
  }

  @Override
  public Post getAPostBypostId(String postId) {
    Optional<Integer> optionPostId = parsePostId(postId);
    if (optionPostId.isPresent()) {
      int postIdValue = optionPostId.get();
      Post post = postService.getAPostBypostId(postIdValue);
      return post;
    } else {
      // handle invalid post id
      return null;
    }
  }


  private Optional<Integer> parseUserId(String userId) {
    try {
      int userIdValue = Integer.parseInt(userId);
      return Optional.of(userIdValue);
    } catch (NumberFormatException e) {
      // handle invalid user id
      return Optional.empty();
    }
  }

  private Optional<Integer> parsePostId(String postId) {
    try {
      int postIdValue = Integer.parseInt(postId);
      return Optional.of(postIdValue);
    } catch (NumberFormatException e) {
      // handle invalid post id
      return Optional.empty();
    }
  }


}
