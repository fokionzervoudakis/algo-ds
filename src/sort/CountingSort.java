package sort;

import annotation.NotInPlace;
import annotation.Stable;

class CountingSort {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_best=O(n+k)
     <li>time_avg=O(n+k)
     <li>time_worst=O(n+k)
     <li>space_worst=O(k)
     </ul>

     @param A the array to be sorted
     */
    @NotInPlace
    @Stable
    int[] sort(int[] A, int k) {
        int[] B = new int[k];
        for (int n : A) {
            B[n]++;
        }
        for (int i = 1; i < k; i++) {
            B[i] += B[i - 1];
        }
        int[] C = new int[A.length];
        for (int n : A) {
            C[--B[n]] = n;
        }
        return C;
    }
}
