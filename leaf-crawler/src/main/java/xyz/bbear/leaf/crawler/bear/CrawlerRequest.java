package xyz.bbear.leaf.crawler.bear;

import lombok.Data;
import lombok.ToString;
import okhttp3.internal.http.HttpMethod;

/**
 * Request.
 *
 * @author xiongliu wu 2019-05-08 15:05
 */
@Data
@ToString
public class CrawlerRequest {
  private Method method;
  private String url;

  public CrawlerRequest() {}

  public CrawlerRequest(Method method, String url) {
    this.method = method;
    this.url = url;
  }
}
