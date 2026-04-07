package distributedCache.eviction;

public class Node<K> {
    K key;
    Node<K> prev;
    Node<K> next;

    public Node(K key) {
        this.key = key;
    }
}