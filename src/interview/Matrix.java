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

    int[][] transpose(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = M[j][i];
            }
        }
        return tmp;
    }

    int[][] swapColumns(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = M[m - i - 1][j];
            }
        }
        return tmp;

    }

    int[][] swapRows(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = M[i][n - j - 1];
            }
        }
        return tmp;
    }
}
