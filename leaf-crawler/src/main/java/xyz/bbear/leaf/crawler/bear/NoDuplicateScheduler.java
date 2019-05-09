package xyz.bbear.leaf.crawler.bear;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * NoDuplicateScheduler.
 *
 * @author xiongliu wu 2019-05-09 09:54
 */
public class NoDuplicateScheduler implements Scheduler {

    private ConcurrentMap<String,Boolean> visited = new ConcurrentHashMap<>();
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
        Boolean visited = this.visited.get(request.getUrl());
        if(visited == null || !visited){
            this.visited.put(request.getUrl(), true);
            requests.add(request);
        }
    }
}
