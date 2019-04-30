package search;

import annotation.Bitwise;
import annotation.InPlace;

class QuickSelect {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_best=O(n)
     <li>time_avg=O(n)
     <li>time_worst=O(n^2)
     <li>space_worst=O(1)
     </ul>

     @param A the array to be searched
     @param k the {@code k}th smallest element to be searched for
     @return the {@code k}th smallest element in {@code A}, if {@code A} contains
     a {@code k}th smallest element, else null
     */
    @Bitwise
    @InPlace
    Integer it(int[] A, int k) {
        int l = 0, r = A.length - 1;
        while (r >= l) {
            int mid = (l + r) >>> 1;
            swap(A, mid, r);
            int pivot = l;
            for (int i = l; i < r; i++) {
                if (A[i] < A[r]) {
                    swap(A, i, pivot++);
                }
            }
            swap(A, pivot, r);
            if (pivot < k) {
                l = pivot + 1;
            } else if (pivot > k) {
                r = pivot - 1;
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
