package com.vtxlab.demo.demoresttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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
      private String lat;
      private String lng;
    }
  }
}
