package misc;

class Knapsack {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_worst=O(2^n)
     <li>space_worst=O(n)
     </ul>

     @param w the item weights
     @param v the item values
     @param size the size of the knapsack
     @return the max value that can be obtained from items with {@code w} weights
     and {@code v} values when total weight is less than or equal to {@code size}
     */
    int max(int[] w, int[] v, int size) {
        return helper(w, v, 0, size);
    }

    private int helper(int[] w, int[] v, int i, int size) {
        if (i == w.length) {
            return 0;
        } else {
            int a = helper(w, v, i + 1, size);
            int b = (size >= w[i]) ? helper(w, v, i + 1, size - w[i]) + v[i] : 0;
            return Math.max(a, b);
        }
    }
}
