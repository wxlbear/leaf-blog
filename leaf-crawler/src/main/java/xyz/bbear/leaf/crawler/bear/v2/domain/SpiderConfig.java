package xyz.bbear.leaf.crawler.bear.v2.domain;

import java.util.List;
import lombok.Data;

/**
 * SpiderConfig 爬虫配置.
 *
 * @author xiongliu wu 2019-05-29 18:53
 */
@Data
public class SpiderConfig {

  /** 是否使用代理. */
  private Boolean useProxy;

  /** 启动多少个爬虫线程. */
  private int threadNum;

  /** 解析字段模板配置. */
  private String fieldConfigJson;

  private List<String> seeds;
}
