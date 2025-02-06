package Applications.RateLimiter.TokenBucket;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimiter{
    private int bucketCapacity;
    private int refreshRate; // No. of tokens added per unit of seconds.
    private AtomicInteger currentCapacity;
    private AtomicLong lastUpdatedTime;


    public TokenBucket(int bucketCapacity, int refreshRate){
        this.bucketCapacity = bucketCapacity;
        this.refreshRate = refreshRate;
        currentCapacity = new AtomicInteger();
        lastUpdatedTime = new AtomicLong();
        currentCapacity.getAndSet(bucketCapacity);
        lastUpdatedTime.getAndSet(System.currentTimeMillis());
    }


    @Override
    public boolean grantAccess(){
        refreshBucket();
        if(currentCapacity.get() > 0){
            currentCapacity.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refreshBucket(){
        long currentTime = System.currentTimeMillis();
        int additionToken = (int)((currentTime - lastUpdatedTime.get())/1000)*refreshRate; // total time elapsed in seconds multiplied by refreshRate (Number of tokens being added per second).
        int currCapacity = Math.min (currentCapacity.get() + additionToken, bucketCapacity);
        currentCapacity.getAndSet(currCapacity);
        lastUpdatedTime.getAndSet(currentTime);
    }


}
