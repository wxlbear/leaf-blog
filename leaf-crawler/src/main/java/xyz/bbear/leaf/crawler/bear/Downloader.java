package xyz.bbear.leaf.crawler.bear;

/**
 * Downloader.
 *
 * @author xiongliu wu 2019-05-08 15:16
 */
public interface Downloader {
  CrawlerResponse download(CrawlerRequest request);
}
