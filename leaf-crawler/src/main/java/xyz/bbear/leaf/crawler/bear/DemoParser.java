package xyz.bbear.leaf.crawler.bear;

/**
 * DemoParser.
 *
 * @author xiongliu wu 2019-05-08 15:33
 */
public class DemoParser implements Parser {

  @Override
  public Result parse(CrawlerResponse response) {
    System.out.println("parser....." + response);
    return null;
  }
}
