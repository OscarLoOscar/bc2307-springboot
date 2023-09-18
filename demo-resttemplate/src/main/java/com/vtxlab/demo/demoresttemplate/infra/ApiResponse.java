package com.vtxlab.demo.demoresttemplate.infra;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vtxlab.demo.demoresttemplate.infra.exception.BizCode;
import com.vtxlab.demo.demoresttemplate.infra.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
  boolean success;

  //@JsonProperty(value = "status")//將code 改名成status
  int code;
  String message;
  T data;

  public ApiResponse(Builder<T> builder) {
    this.success = builder.success;
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  public static class Builder<T> {
    boolean success;
    int code;
    String message;
    T data;

    // success()
    public Builder<T> ok() {
      this.success = BizCode.SUCCESS.isSuccess();
      this.code = BizCode.SUCCESS.getCode();
      this.message = BizCode.SUCCESS.getMessage();
      return this;
    }

    public Builder<T> error(BusinessException e) {
      this.success = false;
      this.code = e.getCode();
      this.message = e.getMessage();
      return this;
    }

    public Builder<T> status(BizCode bCode) {
      this.success = bCode.isSuccess();
      this.code = bCode.getCode();
      this.message = bCode.getMessage();
      return this;
    }


    private Builder<T> success(boolean success) {
      this.success = success;
      return this;
    }

    private Builder<T> code(int code) {
      this.code = code;
      return this;
    }

    public Builder<T> message(String message) {
      this.message = message;
      return this;
    }

    public Builder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResponse<T> build() {
      if (this.code == 0 || this.message == null)
        throw new RuntimeException();
      return new ApiResponse<>(this);
    }
  }

}
