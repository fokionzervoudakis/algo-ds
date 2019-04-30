package interview;

class ClusterCount {
    private boolean[][] visited;

    int count(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(M, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] M, int m, int n) {
        visited[m][n] = true;
        for (int i = m - 1; i < m + 2; i++) {
            for (int j = n - 1; j < n + 2; j++) {
                if ((i >= 0 && i < M.length) && (j >= 0 && j < M[0].length)) {
                    if (M[i][j] == 1 && !visited[i][j]) {
                        dfs(M, i, j);
                    }
                }
            }
        }
    }
}
