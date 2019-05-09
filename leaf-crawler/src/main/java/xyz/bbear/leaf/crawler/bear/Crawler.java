package xyz.bbear.leaf.crawler.bear;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Crawler.
 *
 * @author xiongliu wu 2019-05-08 14:37
 */
public abstract class Crawler implements Runnable {

  private volatile boolean run;

  protected final Scheduler scheduler;
  private final Downloader downloader;
  private final Parser parser;
  private final Pipeline pipeline;
  private AtomicLong counter;

  public Crawler(Scheduler scheduler, Downloader downloader, Parser parser, Pipeline pipeline) {
    on();
    this.scheduler = scheduler;
    this.downloader = downloader;
    this.parser = parser;
    this.pipeline = pipeline;
  }

  public void on() {
    this.run = true;
  }

  public void off() {
    this.run = false;
  }

  @Override
  public void run() {
    while (this.run) {
      System.out.println("running");
      crawler();
    }
  }

  private void crawler() {
    // 使用阻塞的话，可能会导致爬虫停止不了.
    CrawlerRequest request = this.scheduler.take();
    if (request == null) {
      return;
    }
    CrawlerResponse response = this.downloader.download(request);
    if (response == null) {
      return;
    }
    addNewRequests(response);
    Result result = this.parser.parse(response);
    if (result == null) {
      return;
    }
    this.pipeline.pipeline(result);
    counter.incrementAndGet();
  }

  protected abstract void addNewRequests(CrawlerResponse response);
}
