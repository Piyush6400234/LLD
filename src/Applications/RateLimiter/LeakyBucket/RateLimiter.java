package Applications.RateLimiter.LeakyBucket;

public interface RateLimiter {
    boolean grantAccess();
}
