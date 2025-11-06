class Solution {
    private class Pair {
        int first;
        int second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public void bfs(int ro, int co, int[][] vis, char[][] grid, int n, int m) {
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(ro, co));
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == 'L' && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1;
                        q.offer(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L' && visited[i][j] == 0) {
                    cnt++;
                    bfs(i, j, visited, grid, n, m);
                }
            }
        }
        return cnt;
    }
}
