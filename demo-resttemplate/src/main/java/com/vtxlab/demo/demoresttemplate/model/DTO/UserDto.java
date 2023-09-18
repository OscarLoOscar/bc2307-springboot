package com.vtxlab.demo.demoresttemplate.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
  private int id;
  private String name;

  @JsonProperty(value = "changedName")
  private String username;
  private String email;
  private String phone;

  // 出入同一個class： List<User>搵唔到對方個value，所以output null，，default 唔會死
  // Object -> User , Serialize -> cant find name : x
  // DTO ->拆兩個class
  // 一個問人拎野，一個pass 野出返去
  // 唔應該因為JsonPlaceHolder 改名 , Consumer 要跟住改
  // 所以分離
}

