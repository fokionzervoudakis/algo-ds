package sort;

import annotation.InPlace;
import annotation.Stable;

class BubbleSort {
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
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] > A[i + 1]) {
                    swap(A, i, i + 1);
                    end = false;
                }
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int n = A[i];
        A[i] = A[j];
        A[j] = n;
    }
}
