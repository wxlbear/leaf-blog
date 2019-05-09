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
public class DuplicateScheduler implements Scheduler {

    private BlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    @Override
    public Request take() {
        try {
            return requests.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(Request request) {
        requests.add(request);
    }
}
