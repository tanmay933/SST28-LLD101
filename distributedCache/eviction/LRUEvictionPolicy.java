package distributedCache.eviction;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

    private Map<K, Node<K>> map = new HashMap<>();
    private DoublyLinkedList<K> dll = new DoublyLinkedList<>();

    @Override
    public void keyAccessed(K key) {
        // TODO
    }

    @Override
    public K evictKey() {
        // TODO
        return null;
    }
}