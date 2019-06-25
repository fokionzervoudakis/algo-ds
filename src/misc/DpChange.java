package misc;

class DpChange {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_worst=O(mn)
     <li>space_worst=O(n)
     </ul>

     @param C coins of different denominations represented as an array of
     integers
     @param n a target sum
     @return the min number of coins in {@code A} needed to derive {@code n}, or
     -1 if {@code n} cannot be derived
     */
    int make(int[] C, int n) {
        int[] B = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            B[i] = n + 1;
        }
        for (int c : C) {
            for (int i = c; i <= n; i++) {
                B[i] = Math.min(B[i], B[i - c] + 1);
            }
        }
        return B[n] > n ? -1 : B[n];
    }
}
