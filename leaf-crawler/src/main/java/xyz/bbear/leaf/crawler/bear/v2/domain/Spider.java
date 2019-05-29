package xyz.bbear.leaf.crawler.bear.v2.domain;

import lombok.Data;

/**
 * Spider.
 *
 * @author xiongliu wu 2019-05-29 19:05
 */
@Data
public class Spider {

  /** 爬虫id. */
  private Long id;

  /** 爬虫名称. */
  private String name;

  /** 爬虫简介. */
  private String description;

  /** 爬虫配置关联id. */
  private Integer configId;
}
