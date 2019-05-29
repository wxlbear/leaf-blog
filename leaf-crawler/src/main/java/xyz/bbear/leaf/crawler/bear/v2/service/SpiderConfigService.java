package xyz.bbear.leaf.crawler.bear.v2.service;

import xyz.bbear.leaf.crawler.bear.v2.domain.SpiderConfig;

/**
 * SpiderConfigService.
 *
 * @author xiongliu wu 2019-05-29 19:01
 */
public interface SpiderConfigService {

  SpiderConfig load(String spiderId);
}
