package Applications.RateLimiter.LeakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer, LeakyBucket> bucket; // ideally for distributed system we will store this in distributed cache.

    public UserBucketCreator(int id){
        bucket = new HashMap<>();
        bucket.put(id, new LeakyBucket(10)); // we can define capacity of each bucket in a config file.
    }

    void accessApplication(int id){
        if(bucket.get(id).grantAccess()){ // this also we can get from distributed cache.
            System.out.println(Thread.currentThread().getName()+ " ->Able to access the application");
        }
        else{
            System.out.println(Thread.currentThread().getName()+" -> Too many requests in my queue, please try after some time!!");
        }
    }


}
