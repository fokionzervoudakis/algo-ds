package sort;

import annotation.InPlace;
import annotation.Stable;

class InsertionSort {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_best=O(n)
     <li>time_avg=O(n^2)
     <li>time_worst=O(n^2)
     <li>space_worst=O(1)
     </ul>

     @param A the array to be sorted
     */
    @InPlace
    @Stable
    void sort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int n = A[i], j = i;
            while (j > 0 && A[j - 1] > n) {
                A[j] = A[j-- - 1];
            }
            A[j] = n;
        }
    }
}
