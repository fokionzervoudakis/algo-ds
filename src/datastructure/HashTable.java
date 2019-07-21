package datastructure;

import java.util.Arrays;

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
class HashTable<K, V> {
    // Set the default initial capacity to eight because many hash functions require power of two table sizes.
    // Double and rehash (not implemented) when the number of keys n equals the number of slots m.
    // Shrink to half size and rehash (also not implemented) when m equals n/k where k is any constant greater than two.
    Node<K, V>[] A = new Node[8];

    void put(K k, V v) {
        int i = hash(k);
        Node<K, V> N = new Node<>(k, v);
        // Resolve collisions with chaining (vs open addressing).
        N.next = A[i];
        A[i] = N;
    }

    V get(K k) {
        int i = hash(k);
        Node<K, V> N = A[i];
        while (N != null) {
            if (k.equals(N.k)) {
                return N.v;
            } else {
                N = N.next;
            }
        }
        return null;
    }

    V remove(K k) {
        int i = hash(k);
        Node<K, V> curr = A[i], prev = null;
        while (curr != null) {
            if (k.equals(curr.k)) {
                if (curr.next == null) {
                    if (prev == null) {
                        A[i] = null;
                    } else {
                        prev.next = null;
                    }
                    return curr.v;
                } else {
                    V v = curr.v;
                    curr.k = curr.next.k;
                    curr.v = curr.next.v;
                    curr.next = curr.next.next;
                    return v;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return null;
    }

    private int hash(K k) {
        return k.hashCode() % A.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(A);
    }

    class Node<K, V> {
        K k;
        V v;
        Node<K, V> next;

        Node(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public String toString() {
            String out = k + ": " + v;
            return (next == null) ? out : out + " -> " + next;
        }
    }
}
