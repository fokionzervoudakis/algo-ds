package sort;

import annotation.NotInPlace;
import annotation.Stable;

import java.util.Arrays;

class MergeSort {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_best=O(n log n)
     <li>time_avg=O(n log n)
     <li>time_worst=O(n log n)
     <li>space_worst=O(n)
     </ul>
     */
    @NotInPlace
    @Stable
    int[] sort(int[] A) {
        int n = A.length;
        if (n < 2) {
            return A;
        }
        int mid = n / 2;
        int[] B = Arrays.copyOfRange(A, 0, mid);
        int[] C = Arrays.copyOfRange(A, mid, n);
        return merge(sort(B), sort(C));
    }

    private int[] merge(int[] B, int[] C) {
        int m = B.length, n = C.length;
        int[] A = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (j < m && k < n) {
            A[i++] = (B[j] < C[k]) ? B[j++] : C[k++];
        }
        while (j < m) {
            A[i++] = B[j++];
        }
        while (k < n) {
            A[i++] = C[k++];
        }
        return A;
    }
}
