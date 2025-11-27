class Solution {
    public boolean dfs(int r, int c, int[][] grid, boolean[][] visited, int n, int m) {
        if (r < 0 || r >= n || c < 0 || c >= m)
            return false;
        if (grid[r][c] == 1)
            return true;
        if (visited[r][c])
            return true;
        visited[r][c] = true;
        boolean left = dfs(r, c - 1, grid, visited, n, m);
        boolean right = dfs(r, c + 1, grid, visited, n, m);
        boolean up = dfs(r - 1, c, grid, visited, n, m);
        boolean down = dfs(r + 1, c, grid, visited, n, m);
        return left && right && up && down;
    }

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (dfs(i, j, grid, visited, n, m)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
