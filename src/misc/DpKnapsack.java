package misc;

import annotation.dp.Memoization;
import annotation.dp.Tabulation;

import java.util.Map;
import java.util.TreeMap;

class DpKnapsack {
    class Mem {
        Map<String, Integer> M = new TreeMap<>();

        /**
         Uses recursive (top-down) dynamic programming with memoization to
         solve the knapsack problem.
         <ul>
         <li>time_worst=O(mn)
         <li>space_worst=O(mn)
         </ul>

         @param w the item weights
         @param v the item values
         @param size the size of the knapsack
         @return the max value that can be obtained from items with {@code w}
         weights and {@code v} values when total weight is less than or equal to
         {@code size}
         */
        @Memoization
        int max(int[] w, int[] v, int size) {
            return helper(w, v, 0, size);
        }

        private int helper(int[] w, int[] v, int i, int size) {
            String key = i + "" + size;
            if (M.containsKey(key)) {
                return M.get(key);
            } else {
                int max;
                if (i == w.length) {
                    max = 0;
                } else {
                    int a = helper(w, v, i + 1, size);
                    int b = (size >= w[i]) ? helper(w, v, i + 1, size - w[i]) + v[i] : 0;
                    max = Math.max(a, b);
                }
                M.put(key, max);
                return max;
            }
        }
    }

    class Tab {
        /**
         Uses iterative (bottom-up) dynamic programming with tabulation to solve
         the knapsack problem.
         <ul>
         <li>time_worst=O(mn)
         <li>space_worst=O(mn)
         </ul>

         @param w the item weights
         @param v the item values
         @param size the size of the knapsack
         @return the max value that can be obtained from items with {@code w}
         weights and {@code v} values when total weight is less than or equal to
         {@code size}
         */
        @Tabulation
        int max(int[] w, int[] v, int size) {
            int m = w.length;
            int[][] M = new int[m + 1][size + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= size; j++) {
                    int a = M[i - 1][j];
                    int b = (j >= w[i - 1]) ? M[i - 1][j - w[i - 1]] + v[i - 1] : 0;
                    M[i][j] = Math.max(a, b);
                }
            }
            return M[m][size];
        }
    }
}
