package com.vtxlab.demo.demoresttemplate.services.impl;

import java.util.List;
import com.vtxlab.demo.demoresttemplate.model.Comment;

public interface CommentServiceImpl {
  List<Comment> getAllComment();

  List<Comment> getAllCommentByPostId(int postId);

  Comment getACommentByCommentId(int commentId);

}

