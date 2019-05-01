package sort;

import annotation.InPlace;
import annotation.Unstable;

class SelectionSort {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_best=O(n^2)
     <li>time_avg=O(n^2)
     <li>time_worst=O(n^2)
     <li>space_worst=O(1)
     </ul>

     @param A the array to be sorted
     */
    @InPlace
    @Unstable
    void sort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int min = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[min] > A[j]) {
                    min = j;
                }
            }
            swap(A, i, min);
        }
    }

    private void swap(int[] A, int i, int j) {
        int n = A[i];
        A[i] = A[j];
        A[j] = n;
    }
}
