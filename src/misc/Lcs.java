package misc;

/**
 {@link Diff}
 */
class Lcs {
    /**
     Calculates the length of the longest common sub-sequence (i.e. the longest
     sequence of characters common to all sequences) in two arrays.
     <p>
     For example, the longest common sub-sequence of "1234" and "1224533324" is
     "1234".
     <ul>
     <li>time_worst=O(mn)
     <li>space_worst=O(mn)
     </ul>

     @param A the first array
     @param B the second array
     @return the length of the longest sequence common to all sequences in {@code
     A} and {@code B}
     */
    int len(char[] A, char[] B) {
        int m = A.length, n = B.length;
        int[][] M = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    M[i][j] = M[i - 1][j - 1] + 1;
                } else {
                    M[i][j] = Math.max(M[i - 1][j], M[i][j - 1]);
                }
            }
        }
        return M[m][n];
    }
}
