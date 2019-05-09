package xyz.bbear.leaf.crawler.bear;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * CrawlerRunner.
 *
 * @author xiongliu wu 2019-05-08 14:52
 */
public class CrawlerRunner {

  private final int threadNum;
  private final Crawler crawler;
  private static final Downloader DEFAULT_DOWNLOADER = new OkHttpDownloader();
  private static final Pipeline DEFAULT_PIPELINE = new ConsolePipeline();

  public CrawlerRunner(int threadNum, Crawler crawler) {
    this.threadNum = threadNum;
    this.crawler = crawler;
  }

  public static CrawlerRunner create(int threadNum, Crawler crawler) {
    CrawlerRunner crawlerRunner = new CrawlerRunner(threadNum, crawler);
    return crawlerRunner;
  }

  public void start() {
    ExecutorService executorService = Executors.newFixedThreadPool(this.threadNum);
    for (int i = 0; i < threadNum; i++) {
      executorService.execute(crawler);
    }
    executorService.shutdown();
  }

  public void stop() {
    this.crawler.off();
  }

  public static void main(String[] args) throws InterruptedException {
    Scheduler scheduler = new DuplicateScheduler();
    scheduler.add(new Request("get", "seed"));
    CrawlerRunner runner =
        CrawlerRunner.create(
            10, new DemoCrawler(scheduler, DEFAULT_DOWNLOADER, new DemoParser(), DEFAULT_PIPELINE));
    runner.start();
    Thread.sleep(5000);
    runner.stop();
  }
}
