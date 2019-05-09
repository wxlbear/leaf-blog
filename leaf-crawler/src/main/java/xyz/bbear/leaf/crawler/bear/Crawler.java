package xyz.bbear.leaf.crawler.bear;

import java.util.concurrent.BlockingDeque;

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

  public Crawler(
      Scheduler scheduler, Downloader downloader, Parser parser, Pipeline pipeline) {
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
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void crawler() {
      Request request = this.scheduler.take();
      if(request == null){
        return;
      }
      Response response = this.downloader.download(request);
      addNewRequests(response);
      Result result = this.parser.parse(response);
      this.pipeline.pipeline(result);

  }

  protected abstract void addNewRequests(Response response);
}
