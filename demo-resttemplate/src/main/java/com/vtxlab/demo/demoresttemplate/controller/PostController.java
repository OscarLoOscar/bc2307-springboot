package com.vtxlab.demo.demoresttemplate.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.demoresttemplate.controller.impl.PostOperation;
import com.vtxlab.demo.demoresttemplate.infra.ApiResponse;
import com.vtxlab.demo.demoresttemplate.infra.exception.BizCode;
import com.vtxlab.demo.demoresttemplate.infra.exception.BusinessException;
import com.vtxlab.demo.demoresttemplate.model.Post;
import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.services.PostService;
import com.vtxlab.demo.demoresttemplate.services.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class PostController implements PostOperation {

  @Autowired
  PostService postService;

  @Override
  public ResponseEntity<ApiResponse<List<Post>>> getAllPostByUserId(
      String userId) {
    int conventPostId = Integer.parseInt(userId);
    List<Post> post = postService.getAllPostByUserId(conventPostId);

    try {
      // Optional<User> optionUserId = parseUserId(userId);

      // int userIdValue = optionUserId.get().getId();

      if (post != null) {
        // int userIdValue = optionUserId.get();
      //  List<Post> posts = postService.getAllPostByUserId(conventPostId);
        ApiResponse<List<Post>> successPost = ApiResponse.<List<Post>>builder()//
            .ok()//
            .data(post)//
            .build();
        return ResponseEntity.ok(successPost);
      } else {
        // handle invalid user id
        ApiResponse<List<Post>> idNotFound = ApiResponse.<List<Post>>builder()//
            .error(BusinessException.of(//
                BizCode.USER_NOT_FOUND.getCode(), //
                BizCode.USER_NOT_FOUND.getMessage() + userId))//
            .build();
        return ResponseEntity.badRequest().body(idNotFound);
      }
    } catch (NumberFormatException e) {
      ApiResponse<List<Post>> inValidInput = ApiResponse.<List<Post>>builder()//
          .error(BusinessException.of(//
              BizCode.INVALID_INPUT.getCode(), //
              BizCode.INVALID_INPUT.getMessage() + userId))//
          .build();
      return ResponseEntity.badRequest().body(inValidInput);
    }
  }

  @Override
  public List<Post> getAllPost() {
    return postService.getAllPost();
  }

  @Override
  public ResponseEntity<ApiResponse<Post>> getAPostBypostId(String postId) {
    // without ResponseEntity<ApiResponse>
    // Optional<Integer> optionPostId = parsePostId(postId);
    // if (optionPostId.isPresent()) {
    // int postIdValue = optionPostId.get();
    // Post post = postService.getAPostBypostId(postIdValue);
    // return post;
    // } else {
    // // handle invalid post id
    // return null;
    // }

    // Optional<Post> optionUserId = parsePostId(postId);
    // int userIdValue = optionUserId.get().getId();
    int conventPostId = Integer.parseInt(postId);
    Post posts = postService.getAPostBypostId(conventPostId);
    try {
      if (posts != null) {
        // if (posts != null) {
        ApiResponse<Post> post = ApiResponse.<Post>builder()//
            .ok()//
            .data(posts)//
            .build();
        return ResponseEntity.ok(post);
      } else {
        // handle invalid user id
        ApiResponse<Post> idNotFound = ApiResponse.<Post>builder()//
            .error(BusinessException.of(//
                BizCode.USER_NOT_FOUND.getCode(), //
                BizCode.USER_NOT_FOUND.getMessage() + postId))//
            .build();
        return ResponseEntity.badRequest().body(idNotFound);
      }
    } catch (NumberFormatException e) {
      ApiResponse<Post> inValidInput = ApiResponse.<Post>builder()//
          .error(BusinessException.of(//
              BizCode.INVALID_INPUT.getCode(), //
              BizCode.INVALID_INPUT.getMessage() + postId))//
          .build();
      return ResponseEntity.badRequest().body(inValidInput);
    }

  }


  // private Optional<User> parseUserId(String userId) {
  //   try {
  //     int userIdValue = Integer.parseInt(userId);
  //     User user = userService.findUser(userIdValue);
  //     return Optional.of(user);
  //   } catch (NumberFormatException e) {
  //     // handle invalid user id
  //     return Optional.empty();
  //   }
  // }

  // private Optional<Post> parsePostId(String postId) {
  //   try {
  //     int postIdValue = Integer.parseInt(postId);
  //     Post post = postService.getAPostBypostId(postIdValue);
  //     return Optional.of(post);
  //   } catch (NumberFormatException e) {
  //     // handle invalid post id
  //     return Optional.ofNullable(null);
  //   }
  // }


}
