package interview;

import java.util.ArrayList;

class PathSearch {
    int search(char[][] M, int x, int y) {
        var len = M.length;

        var visited = new boolean[len][len];

        var Q = new ArrayList<Point>();
        Q.add(new Point(x, y, 0));

        while (!Q.isEmpty()) {
            var p = Q.remove(0);
            if (!visited[p.x][p.y]) {
                visited[p.x][p.y] = true;
                if (M[p.x][p.y] == 'X') {
                    return p.d;
                }
                var d = p.d + 1;
                if (p.x - 1 >= 0) {
                    Q.add(new Point(p.x - 1, p.y, d));
                }
                if (p.x + 1 < len) {
                    Q.add(new Point(p.x + 1, p.y, d));
                }
                if (p.y - 1 >= 0) {
                    Q.add(new Point(p.x, p.y - 1, d));
                }
                if (p.y + 1 < len) {
                    Q.add(new Point(p.x, p.y + 1, d));
                }
            }
        }

        return -1;
    }

    class Point {
        int x;
        int y;
        int d;

        Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
