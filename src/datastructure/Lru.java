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
        Node<K, V> n = new Node<>(k, v);
        M.put(k, n);
        add(n);
        if (M.size() > len) {
            remove(M.remove(tail.prev.k));
        }
    }

    V get(K k) {
        if (M.containsKey(k)) {
            Node<K, V> n = M.get(k);
            remove(n);
            add(n);
            return n.v;
        } else {
            return null;
        }
    }

    private void add(Node<K, V> n) {
        Node<K, V> next = hed.next;
        next.prev = n;
        hed.next = n;
        n.prev = hed;
        n.next = next;
    }

    private void remove(Node<K, V> n) {
        Node<K, V> prev = n.prev, next = n.next;
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
