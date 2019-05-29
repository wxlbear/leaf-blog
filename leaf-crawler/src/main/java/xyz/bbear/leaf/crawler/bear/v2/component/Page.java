package xyz.bbear.leaf.crawler.bear.v2.component;

import lombok.Data;

/**
 * Page.
 *
 * @author xiongliu wu 2019-05-29 18:35
 */
@Data
public class Page {
  private final IQueue queue;

  private String content;

  public Page(IQueue queue) {
    this.queue = queue;
  }

  public void add(String url) {
    try {
      queue.put(url);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
