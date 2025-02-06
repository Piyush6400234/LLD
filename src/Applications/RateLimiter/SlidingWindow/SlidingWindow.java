package Applications.RateLimiter.SlidingWindow;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow implements RateLimiter{
    Queue<Long> slidingWindow;
    int timeWindowInSec;
    int bucketCapacity;

    public SlidingWindow(int bucketCapacity, int timeWindowInSec) {
        this.bucketCapacity = bucketCapacity;
        this.timeWindowInSec = timeWindowInSec;
        slidingWindow = new ConcurrentLinkedQueue<>();
    }

    @Override
    public boolean grantAccess(){
        long currentTime = System.currentTimeMillis();
        checkAndUpdateQueue(currentTime); // remove timestamps from queue beyond current window
        if(slidingWindow.size()<this.bucketCapacity){
            slidingWindow.offer(currentTime);
            return true;
        }
        return false;
    }
    private void checkAndUpdateQueue(long currentTime){
        if(slidingWindow.isEmpty())return;
        long calculatedTime = (currentTime - slidingWindow.peek())/1000;
        while(calculatedTime >= timeWindowInSec){
            slidingWindow.poll();
            if(slidingWindow.isEmpty())break;
            calculatedTime = (currentTime - slidingWindow.peek())/1000;
        }

    }
}