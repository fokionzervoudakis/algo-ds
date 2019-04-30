package misc;

import java.util.ArrayList;
import java.util.List;

class Heap<T> {
    List<T[]> L = new ArrayList<>();

    /**
     Uses Heap's algorithm to generate all possible permutations of {@code A}.
     <ul>
     <li>time_worst=O(n!)
     <li>space_worst=O(n)
     </ul>

     @param A the target array
     @return all possible permutations of {@code A}
     */
    List<T[]> generate(T[] A) {
        helper(A, A.length);
        return L;
    }

    private void helper(T[] A, int n) {
        if (n == 0) {
            L.add(A.clone());
        } else {
            int m = n - 1;
            helper(A, m);
            for (int i = 0; i < m; i++) {
                int j = (n % 2 == 0) ? i : 0;
                swap(A, j, m);
                helper(A, m);
            }
        }
    }

    private void swap(T[] A, int i, int j) {
        T t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
