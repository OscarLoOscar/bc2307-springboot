package com.vtxlab.demo.demoresttemplate.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demo.demoresttemplate.infra.util.UriScheme;
import com.vtxlab.demo.demoresttemplate.model.Post;
import com.vtxlab.demo.demoresttemplate.services.impl.PostServiceImpl;

@Service
public class PostService implements PostServiceImpl {
  @Autowired
  private RestTemplate restTemplate;

  @Value(value = "${api.jsonplaceholder.domain}")
  private String postDomain;

  @Value(value = "${api.jsonplaceholder.endpoint.post}")
  private String postEndpoint;

  @Override
  public List<Post> getAllPost() {
    String url = UriComponentsBuilder.newInstance()//
        .scheme(UriScheme.HTTPS.name())//
        .host(postDomain)//
        .path(postEndpoint)//
        .toUriString();
    Post[] posts = restTemplate.getForObject(url, Post[].class);
    return Arrays.asList(posts);
  }

  @Override
  public List<Post> getAllPostByUserId(int userId) {
    return this.getAllPost().stream()//
        .filter(e -> e.getUserId() == userId)//
        .collect(Collectors.toList());//
    // .findAny()
    // .orElse(null);
  }

  @Override
  public Post getAPostBypostId(int postId) {
    return this.getAllPost().stream()//
        .filter(e -> e.getId() == postId)//
        .findAny()//
        .orElse(null);
  }


}
