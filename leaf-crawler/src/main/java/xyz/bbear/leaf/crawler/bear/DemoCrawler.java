package xyz.bbear.leaf.crawler.bear;

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
  protected void addNewRequests(CrawlerResponse response) {
    this.scheduler.add(new CrawlerRequest(Method.get, "http://www.baidu.com"));
  }
}
