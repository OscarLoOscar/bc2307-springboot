package com.vtxlab.demo.demoresttemplate.controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.vtxlab.demo.demoresttemplate.model.Comment;

public interface CommentOperation {
  @GetMapping(value = "/comments")
  List<Comment> getAllComment();

  @GetMapping(value = "/post/{id}/comments")
  List<Comment> getAllCommentByPostId(@PathVariable(value =  "id") int postId);

  @GetMapping(value = "/comment/{id}")
  Comment getACommentByCommentId(@PathVariable(value = "id") int commentId);

}
