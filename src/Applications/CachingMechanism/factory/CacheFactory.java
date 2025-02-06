package Applications.CachingMechanism.factory;

import Applications.CachingMechanism.Cache;
import Applications.CachingMechanism.HashMapStorage;
import Applications.CachingMechanism.Policy.LRUEvictionPolicy;

public class CacheFactory<Key, Value> {
    public Cache<Key, Value> defaultCache(final int capacity) {
        return new Cache<>(new HashMapStorage<Key, Value>(capacity), new LRUEvictionPolicy<Key>());
    }
}
