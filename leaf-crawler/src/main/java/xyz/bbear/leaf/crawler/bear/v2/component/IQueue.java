package xyz.bbear.leaf.crawler.bear.v2.component;

import java.util.concurrent.TimeUnit;

/**
 * IQueue.
 *
 * @author xiongliu wu 2019-05-29 16:44
 */
public interface IQueue {

  String take() throws InterruptedException;

  String take(int timeout, TimeUnit timeUnit) throws InterruptedException;

  void put(String url) throws InterruptedException;
}
