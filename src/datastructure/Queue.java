package datastructure;

import java.util.Arrays;

/**
 A <em>first in, first out</em> (FIFO) data structure backed by a circular
 buffer.
 <ul>
 <li>space_worst=O(n)
 <li>enqueue_worst=O(1)
 <li>dequeue_worst=O(1)
 <li>peek_worst=O(1)
 </ul>
 */
class Queue<T> {
    // Set the default initial capacity to five (for no particular reason).
    T[] A = (T[]) new Object[5];

    int hed = 0, len = 0;

    void enqueue(T t) {
        if (len + 1 > A.length) {
            resize();
        }
        A[(hed + len++) % A.length] = t;
    }

    T dequeue() {
        T t = A[hed];
        hed = (hed + 1) % A.length;
        len--;
        if (A.length >= len * 3) {
            resize();
        }
        return t;
    }

    private void resize() {
        T[] B = (T[]) new Object[Math.max(len * 2, 1)];
        for (int i = 0; i < len; i++) {
            B[i] = A[(hed + i) % A.length];
        }
        A = B;
        hed = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(A);
    }
}
