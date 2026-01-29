class Solution {
    public void dfs(int row, int col, boolean[][] vis, char[][] board,
                    int[] delrow, int[] delcol) {

        vis[row][col] = true;
        int n = board.length;
        int m = board[0].length;

        for (int d = 0; d < 4; d++) {
            int nrow = row + delrow[d];
            int ncol = col + delcol[d];

            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m
                    && !vis[nrow][ncol] && board[nrow][ncol] == 'O') {

                dfs(nrow, ncol, vis, board, delrow, delcol);
            }
        }
    }
    public void fill(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        // First and last row
        for (int j = 0; j < m; j++) {
            if (!vis[0][j] && grid[0][j] == 'O') {
                dfs(0, j, vis, grid, delrow, delcol);
            }
            if (!vis[n - 1][j] && grid[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, grid, delrow, delcol);
            }
        }

        // First and last column
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && grid[i][0] == 'O') {
                dfs(i, 0, vis, grid, delrow, delcol);
            }
            if (!vis[i][m - 1] && grid[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, grid, delrow, delcol);
            }
        }

        // Flip unvisited O's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
            }
        }
    }
}


