package xyz.bbear.leaf.crawler.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

/**
 * DemoProcessor.
 *
 * @author xiongliu wu 2019-05-08 12:53
 */
public class DemoProcessor implements PageProcessor {

  private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

  @Override
  public void process(Page page) {
    System.out.println(page.getRawText());
  }

  @Override
  public Site getSite() {
    site.setUserAgent(
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.131 Safari/537.36");
    return site;
  }

  public static void main(String[] args) {
    HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
    httpClientDownloader.setProxyProvider(
        SimpleProxyProvider.from(
            new Proxy("http-cla.abuyun.com", 9030, "H98JS6887OO7JN9C", "B3408AD087EB13CE")));
    Spider spider = Spider.create(new DemoProcessor()).setDownloader(httpClientDownloader);
    spider.setUUID("demo");
    for (int i = 0; i < 10; i++) {
      spider
          .addUrl(
              "https://sec-m.ctrip.com/restapi/soa2/10131/json/ViewSpotSearchV1QOC?_fxpcqlniredt=09031087410816214595")
          .thread(5)
          .start();
      System.out.println("for status:" + spider.getStatus());
    }
    System.out.println("end status:" + spider.getStatus());
  }
}
