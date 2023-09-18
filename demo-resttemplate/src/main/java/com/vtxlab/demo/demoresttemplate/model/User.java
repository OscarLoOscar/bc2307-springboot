package com.vtxlab.demo.demoresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor // Jackson
@Builder
public class User {
  private int id;
  private String name;
  private String username;
  private String email;
  Address address;
  private String phone;
  private String website;
  Company company;

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    Geo geo;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Geo {
      // 出入同一個class： List<User>搵唔到對方個value，所以output null，，default 唔會死
      // Object -> User , Serialize -> cant find name : x
      // DTO ->拆兩個class
      // 一個問人拎野，一個pass 野出返去
      // 唔應該因為JsonPlaceHolder 改名 , Consumer 要跟住改
      // 所以分離
      private String lat;
      private String lng;
    }
  }
}
