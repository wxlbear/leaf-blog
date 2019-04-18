package xyz.bbear.api.handler;

import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.bbear.api.model.ExceptionResponse;
import xyz.bbear.common.exceptions.CommonException;

/**
 * CommonExceptionHandler.
 *
 * @author xiongliu wu 2019-04-18 14:27
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

  /**
   * handle Exception.
   *
   * @param response response
   * @param e e
   * @return ExceptionResponse
   */
  @ExceptionHandler(Exception.class)
  public ExceptionResponse handleException(HttpServletResponse response, Exception e) {
    log.error(e.getMessage(), e);
    response.setStatus(500);
    return ExceptionResponse.resultWith(500, e.getMessage(), "050500");
  }

  /**
   * handle CommonException.
   *
   * @param response response
   * @param e e
   * @return ExceptionResponse
   */
  @ExceptionHandler(CommonException.class)
  public ExceptionResponse handleCommonException(HttpServletResponse response, CommonException e) {
    log.error(e.getMessage(), e);
    response.setStatus(e.status);
    return ExceptionResponse.resultWith(e.status, e.errorCode);
  }
}
