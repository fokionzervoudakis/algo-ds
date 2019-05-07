package search;

import annotation.Bitwise;
import annotation.InPlace;
import annotation.pattern.DivideAndConquer;

class QuickSelect {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_best=O(n) with uniformly distributed data
     <li>time_avg=O(n) with uniformly distributed data
     <li>time_worst=O(n^2) with sorted data and the first element as pivot
     <li>space_worst=O(1)
     </ul>
     Based on Lomuto's partition scheme, which uses {@code x=A[r]} as pivot
     element.

     @param A the array to be searched
     @param k the {@code k}th smallest element to be searched for
     @return the {@code k}th smallest element in {@code A}, if {@code A} contains
     a {@code k}th smallest element, else null
     */
    @Bitwise
    @InPlace
    @DivideAndConquer
    Integer it(int[] A, int k) {
        int l = 0, r = A.length - 1;
        while (r >= l) {
            int m = (l + r) >>> 1;
            swap(A, m, r);
            int i = l;
            for (int j = l; j < r; j++) {
                if (A[j] < A[r]) {
                    swap(A, i++, j);
                }
            }
            swap(A, i, r);
            if (i < k) {
                l = i + 1;
            } else if (i > k) {
                r = i - 1;
            } else {
                return A[k];
            }
        }
        return null;
    }

    private void swap(int[] A, int i, int j) {
        int n = A[i];
        A[i] = A[j];
        A[j] = n;
    }
}
