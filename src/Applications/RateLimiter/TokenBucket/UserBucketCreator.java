package Applications.RateLimiter.TokenBucket;


import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer, TokenBucket> bucket; // ideally for distributed system we will store this in distributed cache.

    public UserBucketCreator(int id){
        bucket = new HashMap<>();
        bucket.put(id, new TokenBucket(10, 1)); // we can define capacity of each bucket in a config file.
    }

    void accessApplication(int id){
        if(bucket.get(id).grantAccess()){ // this also we can get from distributed cache.
            System.out.println(Thread.currentThread().getName()+ " ->Able to access the application using token limiter");
        }
        else{
            System.out.println(Thread.currentThread().getName()+" -> Too many requests in my queue using token limiter, please try after some time!!");
        }
    }
}
