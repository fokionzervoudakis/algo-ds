package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NChooseK {
    /**
     Calculates the binomial coefficient {@code n} choose {@code k}: the number
     of {@code k}-element subsets that can be selected from an {@code n}-element
     set.
     <ul>
     <li>time_worst=O(n^k)
     <li>space_worst=O(n)
     </ul>

     @param n a number of possibilities
     @param k a number of outcomes
     @return the binomial coefficient {@code n} choose {@code k}
     */
    int rec(int n, int k) {
        return (k == 0 || k == n) ? 1 : rec(n - 1, k) + rec(n - 1, k - 1);
    }

    class Combinator<T> {
        List<T[]> L = new ArrayList<>();

        /**
         Asymptotic analysis:
         <ul>
         <li>time_worst=O(n^k)
         <li>space_worst=O(n)
         </ul>

         @param A the target array
         @param k the number of combinations
         @return the {@code k}-element combinations of {@code A}
         */
        List<T[]> generate(T[] A, int k) {
            helper(A, 0, k, 0);
            return L;
        }

        private void helper(T[] A, int n, int k, int start) {
            if (n == k) {
                L.add(Arrays.copyOfRange(A, 0, k));
            } else {
                for (int i = start; i < A.length; i++) {
                    swap(A, i, n);
                    helper(A, n + 1, k, i + 1);
                    // backtrack
                    swap(A, i, n);
                }
            }
        }

        private void swap(T[] A, int i, int j) {
            T t = A[i];
            A[i] = A[j];
            A[j] = t;
        }
    }
}
