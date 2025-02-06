package Applications.RateLimiter.TokenBucket;

public interface RateLimiter {
    boolean grantAccess();
}
