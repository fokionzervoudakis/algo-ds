package misc;

class Lis {
    /**
     Asymptotic analysis:
     <ul>
     <li>time_worst=O(2^n)
     <li>space_worst=O(n)
     </ul>

     @param A an array of integers
     @return the length of the longest increasing sub-sequence in {@code A}
     */
    int len(int[] A) {
        return helper(A, 0, Integer.MIN_VALUE);
    }

    private int helper(int[] A, int i, int prev) {
        if (i == A.length) {
            return 0;
        } else {
            int a = helper(A, i + 1, prev);
            int b = (A[i] > prev) ? helper(A, i + 1, A[i]) + 1 : 0;
            return Math.max(a, b);
        }
    }
}
