package xyz.bbear.leaf.crawler.bear;

import java.io.Serializable;
import java.util.Map;
import lombok.Data;
import lombok.ToString;
import okhttp3.Headers;

/**
 * Request.
 *
 * @author xiongliu wu 2019-05-08 15:05
 */
@Data
@ToString
public class CrawlerRequest implements Serializable {
  /** 请求方法. */
  private Method method;

  /** 请求地址. */
  private String url;

  /** 请求header. */
  private Headers headers;

  /** 请求元数据. */
  private Map<String, Object> metaData;

  /** 请求参数. */
  private Map<String, Object> param;

  public CrawlerRequest() {}

  public CrawlerRequest(Method method, String url) {
    this.method = method;
    this.url = url;
  }
}
