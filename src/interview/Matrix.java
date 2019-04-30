package interview;

class Matrix {
    int[][] rotate90Left(int[][] M) {
        return swapColumns(transpose(M));
    }

    int[][] rotate90Right(int[][] M) {
        return swapRows(transpose(M));
    }

    int[][] rotate180(int[][] M) {
        return swapRows(swapColumns(M));
    }

    int[][] transpose(int[][] M1) {
        int m = M1.length, n = M1[0].length;
        int[][] M2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                M2[i][j] = M1[j][i];
            }
        }
        return M2;

    }

    int[][] swapColumns(int[][] M1) {
        int m = M1.length, n = M1[0].length;
        int[][] M2 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M2[i][j] = M1[m - i - 1][j];
            }
        }
        return M2;

    }

    int[][] swapRows(int[][] M1) {
        int m = M1.length, n = M1[0].length;
        int[][] M2 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                M2[i][j] = M1[i][n - j - 1];
            }
        }
        return M2;

    }
}
