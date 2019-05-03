package datastructure;

import java.util.Arrays;

/**
 Asymptotic analysis:
 <ul>
 <li>space_worst=O(1)
 <li>insert_worst=O(1)
 <li>lookup_worst=O(1)
 </ul>
 */
class BloomFilter<T> {
    byte[] A;

    BloomFilter(int n) {
        A = new byte[n];
    }

    void insert(T t) {
        A[hash(t)] = 1;
    }

    boolean lookup(T t) {
        return A[hash(t)] == 1;
    }

    private int hash(T t) {
        return t.hashCode() % A.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(A);
    }
}
