package xyz.bbear.leaf.crawler.bear;

/**
 * Schedule.
 *
 * @author xiongliu wu 2019-05-09 09:52
 */
public interface Scheduler {

    Request take();
    void add(Request request);
}
