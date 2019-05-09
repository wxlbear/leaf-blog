package xyz.bbear.leaf.crawler.bear;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttpDownloader.
 *
 * @author xiongliu wu 2019-05-08 15:33
 */
@Slf4j
public class OkHttpDownloader implements Downloader {

  private static final OkHttpClient okHttpClient = new OkHttpClient();

  @Override
  public CrawlerResponse download(CrawlerRequest request) {
    if(request.getMethod() == Method.get){
      return get(request.getUrl());
    }
    return null;
  }

  private CrawlerResponse get(String url){
    CrawlerResponse crawlerResponse = new CrawlerResponse();
    try {
      Request request = new Request.Builder()
            .url(url)
            .build();

      Response response = okHttpClient.newCall(request).execute();
      String body = response.body().string();
      crawlerResponse.setResponseCode(ResponseCode.success);
      crawlerResponse.setContent(body);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      crawlerResponse.setResponseCode(ResponseCode.error);
      crawlerResponse.setContent(e.getMessage());
    }
    return crawlerResponse;
  }
}
