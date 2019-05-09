package xyz.bbear.leaf.crawler.bear;

import java.util.concurrent.BlockingDeque;

/**
 * DemoCrawler.
 *
 * @author xiongliu wu 2019-05-08 15:31
 */
public class DemoCrawler extends Crawler {

  public DemoCrawler(
      Scheduler scheduler, Downloader downloader, Parser parser, Pipeline pipeline) {
    super(scheduler, downloader, parser, pipeline);
  }

  @Override
  protected void addNewRequests(Response response) {
    this.scheduler.add(new Request("get", "http://www.baidu.com"));
  }
}
