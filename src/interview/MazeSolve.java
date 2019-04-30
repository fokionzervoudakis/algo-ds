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
            // Mark the current position as being part of the search path,
            M[i][j] = P;

            // and try to move up, down, left and right.
            if (solve(M, i - 1, j)
                    || solve(M, i + 1, j)
                    || solve(M, i, j - 1)
                    || solve(M, i, j + 1)) {
                return true;
            }

            // Since all possible moves failed, this position is a dead end so un-mark it,
            M[i][j] = O;

            // and try another path.
            return false;
        }
    }
}
