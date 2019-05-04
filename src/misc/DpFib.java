package misc;

import annotation.dp.Memoization;
import annotation.dp.Tabulation;

import java.util.HashMap;
import java.util.Map;

/**
 MIT 6.006 Lecture 19: DP sub-problem dependencies must be acyclic. DP is thus
 analogous to shortest path discovery in a DAG representation of the search space
 (unless the DAG comprises vertices with multiple dependencies - see Lecture
 21).
 */
class DpFib {
    class Mem {
        Map<Integer, Integer> M = new HashMap<>();

        /**
         Uses recursive (top-down) dynamic programming with memoization to
         calculate the {@code n}th Fibonacci number.
         <ul>
         <li>time_worst=O(n)
         <li>space_worst=O(n)
         </ul>

         @param n a number
         @return the {@code n}th Fibonacci number
         */
        @Memoization
        int fib(int n) {
            if (M.containsKey(n)) {
                return M.get(n);
            } else {
                int f = (n < 2) ? n : fib(n - 1) + fib(n - 2);
                M.put(n, f);
                return f;
            }
        }
    }

    class Tab {
        /**
         Uses iterative (bottom-up) dynamic programming with tabulation to
         calculate the {@code n}th Fibonacci number. DP sub-problem dependencies
         must be iterated in topological order.
         <ul>
         <li>time_worst=O(n)
         <li>space_worst=O(n)
         </ul>

         @param n a number
         @return the {@code n}th Fibonacci number
         */
        @Tabulation
        int fib(int n) {
            int[] A = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                A[i] = (i < 2) ? i : A[i - 1] + A[i - 2];
            }
            return A[n];
        }
    }
}
