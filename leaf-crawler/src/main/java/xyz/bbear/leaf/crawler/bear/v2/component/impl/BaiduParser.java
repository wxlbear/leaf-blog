package xyz.bbear.leaf.crawler.bear.v2.component.impl;

import xyz.bbear.leaf.crawler.bear.v2.component.IParser;
import xyz.bbear.leaf.crawler.bear.v2.component.Page;

/**
 * BaiduParser.
 *
 * @author xiongliu wu 2019-05-29 16:58
 */
public class BaiduParser implements IParser {

  @Override
  public String parse(String content) {
    return null;
  }

  @Override
  public String parse(Page page) {
    String content = page.getContent();
    // parse page content

    for (int i = 0; i < 1000; i++) {
      page.add("new Url");
    }
    return null;
  }
}
