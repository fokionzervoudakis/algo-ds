package datastructure;

import annotation.InPlace;
import annotation.Unstable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 Asymptotic analysis:
 <ul>
 <li>access_worst=O(1)
 <li>delete_worst=O(log n)
 <li>insert_worst=O(log n)
 <li>heapify_worst=O(n)
 <li>space_worst=O(n)
 </ul>
 */
class BinHeap<T> {
    T[] A;

    int len;

    Comparator<T> c;

    BinHeap(Comparator<T> c) {
        // Set the default initial capacity to five (for no particular reason).
        this.A = (T[]) new Object[5];
        this.len = 0;
        this.c = c;
    }

    BinHeap(T[] A, Comparator<T> c) {
        this.A = A;
        this.len = A.length;
        this.c = c;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    void add(T t) {
        if (len + 1 > A.length) {
            resize();
        }
        A[len++] = t;
        siftUp(len - 1);
    }

    private void siftUp(int i) {
        int p = parent(i);
        while (i > 0 && c.compare(A[i], A[p]) < 0) {
            T t = A[i];
            A[i] = A[p];
            A[p] = t;
            i = p;
            p = parent(i);
        }
    }

    T remove() {
        T t = A[0];
        A[0] = A[--len];
        siftDown(0);
        if (A.length >= len * 3) {
            resize();
        }
        return t;
    }

    private void siftDown(int i) {
        do {
            int l = left(i);
            int r = right(i);
            int j;
            if (r < len && c.compare(A[r], A[i]) < 0) {
                j = (c.compare(A[l], A[r]) < 0) ? l : r;
            } else if (l < len && c.compare(A[l], A[i]) < 0) {
                j = l;
            } else {
                j = -1;
            }
            if (j >= 0) {
                T t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
            i = j;
        } while (i >= 0);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return (i * 2) + 1;
    }

    private int right(int i) {
        return (i * 2) + 2;
    }

    /**
     Asymptotic analysis:
     <ul>
     <li>time_best=O(n log n)
     <li>time_avg=O(n log n)
     <li>time_worst=O(n log n)
     <li>space_worst=O(1)
     </ul>
     */
    @InPlace
    @Unstable
    void sort() {
        int n = len;
        while (len > 1) {
            T t = A[--len];
            A[len] = A[0];
            A[0] = t;
            siftDown(0);
        }
        Collections.reverse(Arrays.asList(A));
        len = n;
    }

    private void resize() {
        T[] B = (T[]) new Object[Math.max(len * 2, 1)];
        for (int i = 0; i < len; i++) {
            B[i] = A[i];
        }
        A = B;
    }

    @Override
    public String toString() {
        return Arrays.toString(A);
    }
}
