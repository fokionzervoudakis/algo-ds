package misc;

/**
 {@link Lcs}
 */
class Diff {
    /**
     Uses the solution to the longest common sub-sequence problem (i.e. the
     longest sequence of characters common to all sequences) to diff two arrays.
     <p>
     For example, the longest common sub-sequence of "1234" and "1224533324" is
     "1234".
     <ul>
     <li>time_worst=O(mn)
     <li>space_worst=O(mn)
     </ul>

     @param A the first array
     @param B the second array
     @return the diff of {@code A} and {@code B}
     */
    String diff(char[] A, char[] B) {
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
        return new Print().printDiff(M, A, B, m - 1, n - 1);
    }

    class Print {
        StringBuilder sb = new StringBuilder();

        String printDiff(int[][] M, char[] A, char[] B, int i, int j) {
            if (i >= 0 && j >= 0 && A[i] == B[j]) {
                printDiff(M, A, B, i - 1, j - 1);
                sb.append("  ").append(A[i]);
            } else if (j > 0 && (i == 0 || M[i][j - 1] >= M[i - 1][j])) {
                printDiff(M, A, B, i, j - 1);
                sb.append(" +").append(B[j]);
            } else if (i > 0 && (j == 0 || M[i][j - 1] < M[i - 1][j])) {
                printDiff(M, A, B, i - 1, j);
                sb.append(" -").append(A[i]);
            }
            return sb.toString();
        }
    }
}
