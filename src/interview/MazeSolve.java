package interview;

import annotation.Backtracking;

class MazeSolve {
    @Backtracking
    boolean solve(char[][] M, int i, int j) {
        char G = 'G', O = ' ', P = '+', W = '#';
        char c = M[i][j];
        if (c == G) {
            return true;
        } else if (c == P || c == W) {
            return false;
        } else {
            M[i][j] = P;
            if (solve(M, i - 1, j) || solve(M, i + 1, j) || solve(M, i, j - 1) || solve(M, i, j + 1)) {
                return true;
            }
            M[i][j] = O;
            return false;
        }
    }
}
