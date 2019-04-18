package xyz.bbear.common.exceptions;

import xyz.bbear.common.enums.ErrorCode;

/**
 * CommonException.
 *
 * @author xiongliu Wu 2018-12-03 2:00 PM
 */
public class CommonException extends RuntimeException {

  /** status. */
  public final Integer status;

  /** errorCode enum. */
  public final ErrorCode errorCode;

  /** error message. */
  public final String message;

  /**
   * constructor.
   *
   * @param status status
   * @param errorCode errorCode
   */
  public CommonException(Integer status, ErrorCode errorCode) {
    super(errorCode.msg);
    this.errorCode = errorCode;
    this.message = errorCode.msg;
    this.status = status;
  }
}
