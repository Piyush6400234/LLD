package Applications.RateLimiter.LeakyBucket;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LeakyBucket implements RateLimiter{
    BlockingQueue<Integer> queue;

    public LeakyBucket(int capacity){
        this.queue = new LinkedBlockingQueue<>(capacity);
    }

    @Override
    public boolean grantAccess(){
        // check if queue can take a request add 1 request in queue(1 is just a count of request)
        if(queue.remainingCapacity()>0){
            queue.add(1);
            return true;
        }

        return false;
    }
}
