package xyz.bbear.api.model;

import lombok.Data;

/**
 * ApiResult.
 *
 * @author xiongliu wu 2019/1/2 20:39
 */
@Data
public class ApiResult {

  private int code;

  private String msg;

  private Object data;

  /**
   * result.
   *
   * @param data data
   * @return ApiResult
   */
  public static ApiResult resultWith(Object data) {
    ApiResult apiResult = new ApiResult();
    apiResult.setData(data);
    return apiResult;
  }
}
