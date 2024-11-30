package Applications.CachingMechanism.Policy;

import Applications.CachingMechanism.algorithms.DoublyLinkedList;
import Applications.CachingMechanism.algorithms.DoublyLinkedListNode;

import java.util.*;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{
    private final Map<Key, DoublyLinkedListNode<Key>> map;
    private final DoublyLinkedList<Key> dll;

    public LRUEvictionPolicy() {
        map = new HashMap<>();
        dll = new DoublyLinkedList<>();
    }

    @Override
    public void keyAccessed(final Key key) {
        if (map.containsKey(key)) {
            dll.detachNode(map.get(key));
            dll.insertNodeAtEnd(map.get(key));
        } else {
            final DoublyLinkedListNode<Key> node = dll.insertElementAtEnd(key);
            map.put(key, node);
        }
    }

    @Override
    public Key evict() {
        final DoublyLinkedListNode<Key> lruNode = dll.getFirstNode();
        if (Objects.isNull(lruNode))
            return null;
        dll.detachNode(lruNode);
        map.remove(lruNode.getElement());
        return lruNode.getElement();
    }
}
