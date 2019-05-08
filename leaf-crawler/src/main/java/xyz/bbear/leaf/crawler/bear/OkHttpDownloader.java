package xyz.bbear.leaf.crawler.bear;

/**
 * OkHttpDownloader.
 *
 * @author xiongliu wu 2019-05-08 15:33
 */
public class OkHttpDownloader implements Downloader {

  @Override
  public Response download(Request request) {
    System.out.println("download....." + request);
    return null;
  }
}
