package xyz.bbear.leaf.crawler.bear.v2.component;

/**
 * IQueue.
 *
 * @author xiongliu wu 2019-05-29 16:44
 */
public interface IQueue {

  String take() throws InterruptedException;

  void put(String url) throws InterruptedException;
}
