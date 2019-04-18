package xyz.bbear.common.enums;

/**
 * ErrorCode.
 *
 * @author xiongliu Wu 2018-12-06 2:00 PM
 */
public enum ErrorCode {

  /** gallery not exists. */
  GALLERY_NOT_EXISTS("gallery not exists", "0001");

  /** msg. */
  public final String msg;

  /** code. */
  public final String code;

  ErrorCode(String msg, String code) {
    this.msg = msg;
    this.code = code;
  }
}
