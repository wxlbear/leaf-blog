package xyz.bbear.leaf.crawler.bear;

import java.util.concurrent.BlockingDeque;

/**
 * DemoCrawler.
 *
 * @author xiongliu wu 2019-05-08 15:31
 */
public class DemoCrawler extends Crawler {

  public DemoCrawler(
      BlockingDeque<Request> requests, Downloader downloader, Parser parser, Pipeline pipeline) {
    super(requests, downloader, parser, pipeline);
  }

  @Override
  protected void addNewRequests(Response response) {
    this.requests.add(new Request("get", "http://www.baidu.com"));
  }
}
