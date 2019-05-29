package xyz.bbear.leaf.crawler.bear.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import xyz.bbear.leaf.crawler.bear.v2.component.impl.BaiduParser;
import xyz.bbear.leaf.crawler.bear.v2.component.impl.HttpDownloader;
import xyz.bbear.leaf.crawler.bear.v2.component.impl.MemoryQueue;

/**
 * SpiderEngine.
 *
 * @author xiongliu wu 2019-05-29 16:53
 */
public class SpiderEngine {

    private static List<Spider> spiderList = new ArrayList<>();
    private static List<Thread> threads = new ArrayList<>();
    private static List<Future> futures = new ArrayList<>();

    public static void start(int threadNum){
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            Spider spider = new Spider(new MemoryQueue(), new HttpDownloader(), new BaiduParser());
            Thread thread = new Thread(spider);
            thread.start();
            threads.add(thread);
//            Future<?> submit = executorService.submit(spider);
//            futures.add(submit);
            spiderList.add(spider);
        }

        executorService.shutdown();
    }

    public static void stop(){

//        for (Spider spider : spiderList) {
//            spider.quit();
//        }

        for (Thread thread : threads) {
            thread.interrupt();
        }

//        for (Future future : futures) {
//            future.cancel(true);
//        }
    }


    public static void main(String[] args) throws InterruptedException {
        start(3);

        TimeUnit.SECONDS.sleep(3);
        stop();
    }


}
