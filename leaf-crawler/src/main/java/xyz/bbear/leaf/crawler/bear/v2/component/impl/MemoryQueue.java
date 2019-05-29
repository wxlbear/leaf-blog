package xyz.bbear.leaf.crawler.bear.v2.component.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import xyz.bbear.leaf.crawler.bear.v2.component.IQueue;

/**
 * MemoryQueue.
 *
 * @author xiongliu wu 2019-05-29 16:56
 */
public class MemoryQueue implements IQueue {

  private BlockingQueue<String> bq = new LinkedBlockingDeque<>();

  @Override
  public String take() throws InterruptedException {
    return bq.take();
  }

  @Override
  public String take(int timeout, TimeUnit timeUnit) throws InterruptedException {
    return bq.poll(timeout, timeUnit);
  }

  @Override
  public void put(String url) throws InterruptedException {
    bq.put(url);
  }
}
