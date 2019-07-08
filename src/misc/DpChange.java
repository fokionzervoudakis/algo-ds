package misc;

class DpChange {
    /**
     Uses iterative (bottom-up) dynamic programming with tabulation to solve a
     variation of the knapsack problem.
     <ul>
     <li>time_worst=O(mn)
     <li>space_worst=O(n)
     </ul>

     @param A coins of different denominations represented as an array of
     integers
     @param n a target sum
     @return the min number of coins in {@code A} needed to derive {@code n}, or
     -1 if {@code n} cannot be derived
     */
    int min(int[] A, int n) {
        int[] B = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            B[i] = n + 1;
        }
        for (int coin : A) {
            for (int i = coin; i <= n; i++) {
                B[i] = Math.min(B[i], B[i - coin] + 1);
            }
        }
        return B[n] > n ? -1 : B[n];
    }
}
