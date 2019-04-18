package xyz.bbear.api.model;

import lombok.Data;
import xyz.bbear.common.enums.ErrorCode;

/**
 * CommonException.
 *
 * @author xiongliu Wu 2018-12-03 2:00 PM
 */
@Data
public class ExceptionResponse {

  private Integer status;

  private String error;

  private String errorCode;

  /**
   * constructor.
   *
   * @param status status
   * @param error error
   * @param errorCode errorCode
   */
  public ExceptionResponse(Integer status, String error, String errorCode) {
    this.status = status;
    this.error = error;
    this.errorCode = errorCode;
  }

  public static ExceptionResponse resultWith(Integer status, ErrorCode errorCode) {
    return new ExceptionResponse(status, errorCode.msg, errorCode.code);
  }

  public static ExceptionResponse resultWith(Integer status, String errorMsg, String errorCode) {
    return new ExceptionResponse(status, errorMsg, errorCode);
  }
}
