package interview;

import java.util.LinkedList;

class ClusterSize {
    private boolean[][] visited;

    int max(char[][] M) {
        int m = M.length;
        int n = M[0].length;
        visited = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int tmp = dfs(M, i, j);
                    if (tmp > max) {
                        max = tmp;
                    }
                }
            }
        }
        return max;
    }

    private int dfs(char[][] M, int x, int y) {
        var Q = new LinkedList<Point>();
        Q.add(new Point(x, y));

        int count = 0;

        while (!Q.isEmpty()) {
            var p = Q.removeFirst();
            if (!visited[p.x][p.y] && M[p.x][p.y] == M[x][y]) {
                visited[p.x][p.y] = true;
                count++;
                if (p.x - 1 >= 0) {
                    Q.addLast(new Point(p.x - 1, p.y));
                }
                if (p.x + 1 < M.length) {
                    Q.addLast(new Point(p.x + 1, p.y));
                }
                if (p.y - 1 >= 0) {
                    Q.addLast(new Point(p.x, p.y - 1));
                }
                if (p.y + 1 < M[0].length) {
                    Q.addLast(new Point(p.x, p.y + 1));
                }
            }
        }

        return count;
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
