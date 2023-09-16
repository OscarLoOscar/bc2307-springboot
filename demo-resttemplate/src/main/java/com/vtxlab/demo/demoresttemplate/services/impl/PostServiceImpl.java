package com.vtxlab.demo.demoresttemplate.services.impl;

import java.util.List;
import com.vtxlab.demo.demoresttemplate.model.Post;

public interface PostServiceImpl {

  List<Post> getAllPost();

  List<Post> getAllPostByUserId(int userId);

  Post getAPostBypostId(int postId);
}
