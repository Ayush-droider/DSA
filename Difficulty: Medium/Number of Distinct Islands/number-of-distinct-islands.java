import java.util.*;

class Solution {
    private void dfs(int r, int c, int[][] visited, ArrayList<String> list,int[][] grid, int row0, int col0) {
        visited[r][c] = 1;
        list.add(makeString(r - row0, c - col0));
        int n = grid.length;
        int m = grid[0].length;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nrow = r + delrow[i];
            int ncol = c + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, visited, list, grid, row0, col0);
            }
        }
    }
    private String makeString(int r, int c) {
        return r + " " + c;
    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, visited, list, grid, i, j);
                    st.add(list);
                }
            }
        }

        return st.size();
    }
}
