package xyz.bbear.leaf.crawler.bear.v2.core;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import xyz.bbear.leaf.crawler.bear.v2.component.impl.BaiduParser;
import xyz.bbear.leaf.crawler.bear.v2.component.impl.ConsolePipeline;
import xyz.bbear.leaf.crawler.bear.v2.component.impl.HttpDownloader;
import xyz.bbear.leaf.crawler.bear.v2.component.impl.MemoryQueue;
import xyz.bbear.leaf.crawler.bear.v2.domain.SpiderConfig;
import xyz.bbear.leaf.crawler.bear.v2.model.FieldConfig;

/**
 * SpiderEngine.
 *
 * @author xiongliu wu 2019-05-29 16:53
 */
public class SpiderEngine {

  private final SpiderConfig spiderConfig;

  public SpiderEngine(SpiderConfig spiderConfig) {
    this.spiderConfig = spiderConfig;
  }

  private static List<SpiderWorker> spiderList = new ArrayList<>();

  public void start() {
    int threadNum = spiderConfig.getThreadNum();
    ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
    for (int i = 0; i < threadNum; i++) {
      SpiderWorker spider =
          new SpiderWorker(
              new MemoryQueue(),
              new HttpDownloader(),
              new BaiduParser(),
              new ConsolePipeline(),
              spiderConfig.getSeeds(),
              JSON.parseObject(spiderConfig.getFieldConfigJson(), FieldConfig.class));
      spider.start();
      spiderList.add(spider);
    }

    executorService.shutdown();
  }

  public void stop() {

    for (SpiderWorker spider : spiderList) {
      spider.quit();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    //    start(3, Arrays.asList("http://www.baidu.com"));

    TimeUnit.SECONDS.sleep(3);
    //    stop();
  }
}
