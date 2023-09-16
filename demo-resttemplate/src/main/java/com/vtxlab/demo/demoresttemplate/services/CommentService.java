package com.vtxlab.demo.demoresttemplate.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demo.demoresttemplate.model.Comment;
import com.vtxlab.demo.demoresttemplate.services.impl.CommentServiceImpl;

@Service
public class CommentService implements CommentServiceImpl {
  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "${api.jsonplaceholder.domain}")
  private String commentDpomain;

  @Value(value = "${api.jsonplaceholder.endpoint.comment}")
  private String commentEndpoint;


  @Override
  public List<Comment> getAllComment() {
    String url = UriComponentsBuilder.newInstance()//
        .scheme("https")//
        .host(commentDpomain)//
        .path(commentEndpoint)//
        .toUriString();
    Comment[] comments = restTemplate.getForObject(url, Comment[].class);
    return Arrays.asList(comments);
  }

  @Override
  public List<Comment> getAllCommentByPostId(int postId) {
    return this.getAllComment().stream()//
        .filter(e -> e.getPostId() == postId)//
        .collect(Collectors.toList());
  }

  @Override
  public Comment getACommentByCommentId(int commentId) {
    return this.getAllComment().stream()//
        .filter(e -> e.getId() == commentId)//
        .findFirst()//
        .orElse(null);
  }

}
