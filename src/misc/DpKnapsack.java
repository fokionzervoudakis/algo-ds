package misc;

import annotation.DynamicProgramming;

import java.util.Map;
import java.util.TreeMap;

import static annotation.DynamicProgramming.Type;

class DpKnapsack {
    @DynamicProgramming(Type.MEMOIZATION)
    class Mem {
        Map<String, Integer> M = new TreeMap<>();

        /**
         Uses recursive (top-down) dynamic programming with memoization to
         calculate solve the knapsack problem.
         <ul>
         <li>time_worst=O(n)
         <li>space_worst=O(n)
         </ul>

         @param w the item weights
         @param v the item values
         @param size the size of the knapsack
         @return the max value that can be obtained from items with {@code w}
         weights and {@code v} values when total weight is less than or equal to
         {@code S}
         */
        int max(int[] w, int[] v, int size) {
            return helper(w, v, 0, size);
        }

        private int helper(int[] w, int[] v, int i, int size) {
            String key = i + "" + size;
            if (M.containsKey(key)) {
                return M.get(key);
            } else {
                int max;
                if (i == v.length) {
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

    @DynamicProgramming(Type.TABULATION)
    class Tab {
        /**
         Uses iterative (bottom-up) dynamic programming with tabulation to solve
         the knapsack problem.
         <ul>
         <li>time_worst=O(n)
         <li>space_worst=O(n)
         </ul>

         @param w the item weights
         @param v the item values
         @param size the size of the knapsack
         @return the max value that can be obtained from items with {@code w}
         weights and {@code v} values when total weight is less than or equal to
         {@code S}
         */
        int max(int[] w, int[] v, int size) {
            int m = v.length;
            int[][] memo = new int[m + 1][size + 1];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < size + 1; j++) {
                    if (i == m) {
                        memo[i][j] = 0;
                    } else {
                        int a = memo[i + 1][j];
                        int b = (j >= w[i]) ? memo[i + 1][j - w[i]] + v[i] : 0;
                        memo[i][j] = Math.max(a, b);
                    }
                }
            }
            return memo[0][size];
        }
    }
}
