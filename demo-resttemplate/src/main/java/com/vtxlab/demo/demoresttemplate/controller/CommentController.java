package com.vtxlab.demo.demoresttemplate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.demoresttemplate.controller.impl.CommentOperation;
import com.vtxlab.demo.demoresttemplate.model.Comment;
import com.vtxlab.demo.demoresttemplate.services.CommentService;

@RestController
@RequestMapping(value = "/api/v1")
public class CommentController implements CommentOperation {

  @Autowired
  CommentService commentService;

  @Override
  public List<Comment> getAllComment() {
    return commentService.getAllComment();
  }

  @Override
  public List<Comment> getAllCommentByPostId(int postId) {
    return commentService.getAllCommentByPostId(postId);
  }

  @Override
  public Comment getACommentByCommentId(int commentId) {
    return commentService.getACommentByCommentId(commentId);
  }

}
