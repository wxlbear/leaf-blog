package xyz.bbear.leaf.crawler.bear;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * NoDuplicateScheduler.
 *
 * @author xiongliu wu 2019-05-09 09:54
 */
public class DuplicateScheduler implements Scheduler {

    private BlockingDeque<CrawlerRequest> requests = new LinkedBlockingDeque<>();

    @Override
    public CrawlerRequest take() {
        try {
            return requests.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(CrawlerRequest request) {
        requests.add(request);
    }
}
