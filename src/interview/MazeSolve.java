package interview;

import annotation.pattern.Backtracking;

class MazeSolve {
    static final char GOAL = 'G', OPEN = ' ', PATH = '+', WALL = '#';

    @Backtracking
    boolean solve(char[][] M, int i, int j) {
        char c = M[i][j];
        if (c == GOAL) {
            return true;
        } else if (c == PATH || c == WALL) {
            return false;
        } else {
            M[i][j] = PATH;
            if (solve(M, i - 1, j) || solve(M, i + 1, j) || solve(M, i, j - 1) || solve(M, i, j + 1)) {
                return true;
            }
            M[i][j] = OPEN;
            return false;
        }
    }
}
