package xyz.bbear.leaf.crawler.bear.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import xyz.bbear.leaf.crawler.bear.v2.component.impl.BaiduParser;
import xyz.bbear.leaf.crawler.bear.v2.component.impl.ConsolePipeline;
import xyz.bbear.leaf.crawler.bear.v2.component.impl.HttpDownloader;
import xyz.bbear.leaf.crawler.bear.v2.component.impl.MemoryQueue;

/**
 * SpiderEngine.
 *
 * @author xiongliu wu 2019-05-29 16:53
 */
public class SpiderEngine {

  private static List<Spider> spiderList = new ArrayList<>();

  public static void start(int threadNum, List<String> seedUrls) {
    ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
    for (int i = 0; i < threadNum; i++) {
      Spider spider =
          new Spider(
              new MemoryQueue(),
              new HttpDownloader(),
              new BaiduParser(),
              new ConsolePipeline(),
              seedUrls);
      spider.start();
      spiderList.add(spider);
    }

    executorService.shutdown();
  }

  public static void stop() {

    for (Spider spider : spiderList) {
      spider.quit();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    start(3, Arrays.asList("http://www.baidu.com"));

    TimeUnit.SECONDS.sleep(3);
    //    stop();
  }
}
