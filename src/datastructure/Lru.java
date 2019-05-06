package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 Asymptotic analysis:
 <ul>
 <li>space_avg=O(n)
 <li>insert_agv=O(1)
 <li>lookup_avg=O(1)
 <li>delete_avg=O(1)
 <li>space_worst=O(n)
 <li>insert_worst=O(n)
 <li>lookup_worst=O(n)
 <li>delete_worst=O(n)
 </ul>
 */
class Lru<K, V> {
    Map<K, Node<K, V>> M = new HashMap<>();

    Node<K, V> hed = new Node<>(null, null);
    Node<K, V> tail = new Node<>(null, null);

    int len;

    Lru(int len) {
        this.len = len;
        this.hed.next = tail;
        this.tail.prev = hed;
    }

    void put(K k, V v) {
        if (M.containsKey(k)) {
            remove(M.get(k));
        }
        Node<K, V> N = new Node<>(k, v);
        M.put(k, N);
        add(N);
        if (M.size() > len) {
            remove(M.remove(tail.prev.k));
        }
    }

    V get(K k) {
        if (M.containsKey(k)) {
            Node<K, V> N = M.get(k);
            remove(N);
            add(N);
            return N.v;
        } else {
            return null;
        }
    }

    private void add(Node<K, V> N) {
        Node<K, V> next = hed.next;
        next.prev = N;
        hed.next = N;
        N.prev = hed;
        N.next = next;
    }

    private void remove(Node<K, V> N) {
        Node<K, V> prev = N.prev, next = N.next;
        next.prev = prev;
        prev.next = next;
    }

    @Override
    public String toString() {
        return hed.toString();
    }

    class Node<K, V> {
        K k;
        V v;
        Node<K, V> prev, next;

        Node(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public String toString() {
            return "[" + k + ":" + v + "] -> " + next;
        }
    }
}
