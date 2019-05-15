package interview;

import java.util.ArrayList;
import java.util.List;

class Spiral {
    List<Integer> clockwise(int[][] M) {
        List<Integer> L = new ArrayList<>();
        if (M.length == 0) {
            return L;
        }
        int m = M.length, n = M[0].length;
        int row = 0, col = 0;
        while (row < m && col < n) {
            for (int i = col; i < n; i++) {
                L.add(M[row][i]);
            }
            row++;
            for (int i = row; i < m; i++) {
                L.add(M[i][n - 1]);
            }
            n--;
            if (row < m) {
                for (int i = n - 1; i >= col; i--) {
                    L.add(M[m - 1][i]);
                }
                m--;
            }
            if (col < n) {
                for (int i = m - 1; i >= row; i--) {
                    L.add(M[i][col]);
                }
                col++;
            }
        }
        return L;
    }
}
