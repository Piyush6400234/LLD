package Applications.RateLimiter.SlidingWindow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        UserBucketCreator userBucketCreator = new UserBucketCreator(1);
        ExecutorService executors = Executors.newFixedThreadPool(12);
        for(int i = 0; i<12; i++){
            executors.execute(()-> userBucketCreator.accessApplication(1));
//            userBucketCreator.accessApplication(1);
        }
        executors.shutdown();

    }
}
