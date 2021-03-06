package sort;

import annotation.InPlace;
import annotation.Unstable;
import annotation.pattern.DivideAndConquer;
import rand.Knuth;

public class QuickSort {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_best=O(n log n)
     <li>time_avg=O(n log n)
     <li>time_worst=O(n^2)
     <li>space_worst=O(log n)
     </ul>
     <p>Based on Lomuto's partition scheme, which uses {@code x=A[r]} as the pivot element.
     <p>Use the Knuth shuffle to add randomness and optimize performance (CLRS).
     <p>https://algs4.cs.princeton.edu/23quicksort/

     @param A the array to be sorted
     */
    @InPlace
    @Unstable
    @DivideAndConquer
    void sort(int[] A) {
        Knuth.shuffle(A);
        sort(A, 0, A.length - 1);
    }

    private void sort(int[] A, int l, int r) {
        if (l < r) {
            int p = partition(A, l, r);
            sort(A, l, p - 1);
            sort(A, p + 1, r);
        }
    }

    private int partition(int[] A, int l, int r) {
        int i = l;
        for (int j = l; j < r; j++) {
            if (A[j] < A[r]) {
                swap(A, i++, j);
            }
        }
        swap(A, i, r);
        return i;
    }

    private void swap(int[] A, int i, int j) {
        int n = A[i];
        A[i] = A[j];
        A[j] = n;
    }
}
