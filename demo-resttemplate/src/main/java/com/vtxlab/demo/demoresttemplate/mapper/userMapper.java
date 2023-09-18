package com.vtxlab.demo.demoresttemplate.mapper;

import com.vtxlab.demo.demoresttemplate.model.User;
import com.vtxlab.demo.demoresttemplate.model.DTO.UserDto;

public class userMapper {


  public static UserDto map(User user) {
    return UserDto.builder()//
        .id(user.getId())//
        .name(user.getName())//
        .username(user.getUsername())//
        .email(user.getEmail())//
        .phone(user.getPhone())//
        .build();
  }
}
