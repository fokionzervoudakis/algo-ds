package misc;

class EditDist {
    /**
     Uses dynamic programming to calculate the edit (Levenshtein) distance
     between two character sequences.
     <ul>
     <li>time_worst=O(mn)
     <li>space_worst=O(mn)
     </ul>

     @param A the first character sequence
     @param B the second character sequence
     @return the edit distance between {@code A} and {@code B}
     */
    int editDist(char[] A, char[] B) {
        int m = A.length, n = B.length;
        int[][] M = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            M[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            M[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int cost = (A[i - 1] == B[j - 1]) ? 0 : 1;
                M[i][j] = min(M[i - 1][j] + 1, M[i][j - 1] + 1, M[i - 1][j - 1] + cost);
            }
        }
        return M[m][n];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
