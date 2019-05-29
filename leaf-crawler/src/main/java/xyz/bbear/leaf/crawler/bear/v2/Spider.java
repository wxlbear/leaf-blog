package xyz.bbear.leaf.crawler.bear.v2;

import java.util.concurrent.TimeUnit;

import xyz.bbear.leaf.crawler.bear.v2.component.IDownloader;
import xyz.bbear.leaf.crawler.bear.v2.component.IParser;
import xyz.bbear.leaf.crawler.bear.v2.component.IQueue;

/**
 * Spider.
 *
 * @author xiongliu wu 2019-05-29 16:35
 */
public class Spider implements Runnable{


    private final IQueue queue;
    private final IDownloader downloader;
    private final IParser parser;

    public Spider(IQueue queue, IDownloader downloader, IParser parser) {
        this.queue = queue;
        this.downloader = downloader;
        this.parser = parser;
    }

    @Override
    public void run() {
            try {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + ": crawling....");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e){

            }
    }

    public void quit() {
        System.out.println("someone call me to stop, good bye");
        Thread.currentThread().interrupt();
    }
}

/**
 * 一个爬虫，应该拥有的功能
 * 0. 入口url
 * 1. 有存放url的队列 内存队列或者外部队列
 * 2. 能够下载网页 下载组件
 * 3. 能够解析网页 解析组件
 * 4. 能够存储解析后的数据 存储组件
 * 5. 能够生产新的url 解析组件中生产
 * 6. 能够接受指令：启动，暂停，停止 （爬虫状态管理）
 * 7. 支持多线程，即Spider 是一个线程类
 * <p>
 * 爬虫的生命周期
 * 1. 取得入口地址
 * 2. 下载地址，解析，存储，生产新的地址放入队列
 * 3. 从队列取出url， 回到步骤2
 * 4. 直到队列中再无法取到数据，则停止
 */

