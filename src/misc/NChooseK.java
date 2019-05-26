package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NChooseK<T> {
    List<T[]> L = new ArrayList<>();

    /**
     Generates {@code k}-element combinations from an {@code n}-element set (i.e.
     {@code n} choose {@code k}).
     <p>Asymptotic analysis:
     <ul>
     <li>time_worst=O(n^k)
     <li>space_worst=O(n)
     </ul>

     @param A the target array
     @param k the number of elements per combination
     @return the {@code k}-element combinations of {@code A}
     */
    List<T[]> generate(T[] A, int k) {
        helper(A, A.length, k, 0, 0);
        return L;
    }

    private void helper(T[] A, int n, int k, int i, int j) {
        if (i == k) {
            L.add(Arrays.copyOfRange(A, 0, k));
        } else {
            if (j < n) {
                swap(A, i, j);
                helper(A, n, k, i + 1, j + 1);
                helper(A, n, k, i, j + 1);
                swap(A, i, j);
            }
        }
    }

    private void swap(T[] A, int i, int j) {
        T t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
