package Applications.CachingMechanism.Policy;

public interface EvictionPolicy<Key> {
    void keyAccessed(Key key);
    Key evict();
}
