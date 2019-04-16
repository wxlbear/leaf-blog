package xyz.bbear.common.enums;

/**
 * StatusEnum.
 *
 * @author xiongliu wu 2019-04-16 17:04
 */
public enum StatusEnum {
  active(1),
  delete(0);

  public final int code;

  StatusEnum(int code) {
    this.code = code;
  }
}
