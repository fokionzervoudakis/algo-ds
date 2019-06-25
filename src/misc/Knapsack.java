package misc;

class Knapsack {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_worst=O(2^n)
     <li>space_worst=O(n)
     </ul>

     @param W the item weights
     @param V the item values
     @param size the size of the knapsack
     @return the max value that can be obtained from items with {@code w} weights
     and {@code v} values when total weight is less than or equal to {@code size}
     */
    int max(int[] W, int[] V, int size) {
        return helper(W, V, 0, size);
    }

    private int helper(int[] W, int[] V, int i, int size) {
        if (i == W.length) {
            return 0;
        } else {
            int a = helper(W, V, i + 1, size);
            int b = (size >= W[i]) ? helper(W, V, i + 1, size - W[i]) + V[i] : 0;
            return Math.max(a, b);
        }
    }
}
