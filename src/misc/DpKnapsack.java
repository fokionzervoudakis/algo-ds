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

         @param W the item weights
         @param V the item values
         @param size the size of the knapsack
         @return the max value that can be obtained from items with {@code w}
         weights and {@code v} values when total weight is less than or equal to
         {@code size}
         */
        @Memoization
        int max(int[] W, int[] V, int size) {
            return helper(W, V, 0, size);
        }

        private int helper(int[] W, int[] V, int i, int size) {
            String key = i + ":" + size;
            if (M.containsKey(key)) {
                return M.get(key);
            } else {
                int max;
                if (i == W.length) {
                    max = 0;
                } else {
                    int a = helper(W, V, i + 1, size);
                    int b = (size >= W[i]) ? helper(W, V, i + 1, size - W[i]) + V[i] : 0;
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

         @param W the item weights
         @param V the item values
         @param size the size of the knapsack
         @return the max value that can be obtained from items with {@code w}
         weights and {@code v} values when total weight is less than or equal to
         {@code size}
         */
        @Tabulation
        int max(int[] W, int[] V, int size) {
            int m = W.length;
            int[][] M = new int[m + 1][size + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= size; j++) {
                    int a = M[i - 1][j];
                    int b = (j >= W[i - 1]) ? M[i - 1][j - W[i - 1]] + V[i - 1] : 0;
                    M[i][j] = Math.max(a, b);
                }
            }
            return M[m][size];
        }
    }
}
