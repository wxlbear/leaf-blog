package xyz.bbear.leaf.crawler.bear;

/**
 * Downloader.
 *
 * @author xiongliu wu 2019-05-08 15:16
 */
public interface Downloader {
  Response download(Request request);
}
