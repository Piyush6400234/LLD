package Applications.CachingMechanism;

import Applications.CachingMechanism.Exception.*;

public interface Storage<Key,Value> {
    void add(Key key, Value value) throws StorageFullException;
    void remove(Key key) ;
    Value get(Key key) throws KeyNotFoundException;
}