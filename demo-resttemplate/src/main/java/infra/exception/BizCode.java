package infra.exception;

import org.springframework.web.servlet.FlashMap;
import lombok.Getter;

@Getter
public enum BizCode {

  SUCCESS(20000, true, "SUCCESS"), //
  TIMEOUT(40001, false, "Connect TimeOut"), //
  RESOURCE_NOT_FOUND(40002, false, "Resource Not Found"), //
  REST_CLIENT_EXCEPTION(40003, false, "RestTemplate Api Call Fail"), //
  RESOURCE_ACCESS_EXCEPTION(40004, false, "Resource Access Exception"), //
  INVALID_INPUT(40005, false, "not a invalid number : "), //
  USER_NOT_FOUND(40006, false, "User Not Found : "), //
  DEFAULT(99999, false, "Unknown")//
  ;

  private int code;
  private boolean success;
  private String message;

  private BizCode(int code, boolean success, String message) {
    this.code = code;
    this.success = success;
    this.message = message;
  }
}
