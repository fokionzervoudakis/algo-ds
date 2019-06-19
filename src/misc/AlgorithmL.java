package misc;

import annotation.InPlace;

class AlgorithmL {
    /**
     Uses Knuth's Algorithm L to generate the next lexicographic permutation of
     an element sequence.
     <p>Asymptotic analysis:
     <ul>
     <li>time_worst=O(n)
     <li>space_worst=O(1)
     </ul>

     @param A the target array
     */
    @InPlace
    void next(int[] A) {
        int n = A.length, i = n - 2;
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }
        if (i < 0) {
            return;
        }
        int j = n - 1;
        while (A[i] >= A[j]) {
            j--;
        }
        swap(A, i, j);
        reverse(A, i + 1, n - 1);
    }

    private void reverse(int[] A, int i, int j) {
        while (i < j) {
            swap(A, i++, j--);
        }
    }

    private void swap(int[] A, int i, int j) {
        int n = A[i];
        A[i] = A[j];
        A[j] = n;
    }
}
