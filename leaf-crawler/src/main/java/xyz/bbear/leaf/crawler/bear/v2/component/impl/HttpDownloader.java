package xyz.bbear.leaf.crawler.bear.v2.component.impl;

import xyz.bbear.leaf.crawler.bear.v2.component.IDownloader;

/**
 * HttpDownloader.
 *
 * @author xiongliu wu 2019-05-29 16:57
 */
public class HttpDownloader implements IDownloader {

  @Override
  public String download(String url) {
    System.out.println("download:"+ url);
    return url;
  }
}
