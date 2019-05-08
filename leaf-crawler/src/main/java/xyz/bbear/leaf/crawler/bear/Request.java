package xyz.bbear.leaf.crawler.bear;

import lombok.Data;
import lombok.ToString;

/**
 * Request.
 *
 * @author xiongliu wu 2019-05-08 15:05
 */
@Data
@ToString
public class Request {
  private String method;
  private String url;

  public Request() {}

  public Request(String method, String url) {
    this.method = method;
    this.url = url;
  }
}
