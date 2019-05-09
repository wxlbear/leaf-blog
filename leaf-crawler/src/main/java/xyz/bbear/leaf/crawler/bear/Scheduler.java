package xyz.bbear.leaf.crawler.bear;

/**
 * Schedule.
 *
 * @author xiongliu wu 2019-05-09 09:52
 */
public interface Scheduler {

    CrawlerRequest take();
    void add(CrawlerRequest request);
}
