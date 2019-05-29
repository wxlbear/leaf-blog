package xyz.bbear.leaf.crawler.bear.v2;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.bbear.leaf.crawler.bear.v2.core.SpiderEngine;
import xyz.bbear.leaf.crawler.bear.v2.domain.Spider;
import xyz.bbear.leaf.crawler.bear.v2.domain.SpiderConfig;
import xyz.bbear.leaf.crawler.bear.v2.service.SpiderConfigService;
import xyz.bbear.leaf.crawler.bear.v2.service.SpiderService;

/**
 * SpiderManager.
 *
 * @author xiongliu wu 2019-05-29 19:03
 */
@Component
public class SpiderManager {

  private Map<String, SpiderEngine> engineCache = new HashMap<>();

  @Autowired private SpiderService spiderService;

  @Autowired private SpiderConfigService spiderConfigService;

  /** 创建一个爬虫. */
  public void create(Spider spider) {
    this.spiderService.create(spider);
  }

  /**
   * 启动一个爬虫.
   *
   * @param spiderId spiderId
   */
  public void start(String spiderId) {
    SpiderConfig config = spiderConfigService.load(spiderId);

    SpiderEngine spiderEngine = new SpiderEngine(config);
    spiderEngine.start();
    engineCache.put(spiderId, spiderEngine);
  }

  /**
   * 停止爬虫.
   *
   * @param spiderId spiderId
   */
  public void stop(String spiderId) {
    SpiderEngine engine = engineCache.get(spiderId);
    if (engine != null) {
      engine.stop();
    }
  }
}
