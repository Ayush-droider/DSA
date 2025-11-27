class Solution {

    private class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int totalEnclaveCells = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                    boolean touchesBoundary = false;
                    int cellCount = 0;
                    while (!q.isEmpty()) {
                        Pair p = q.poll();
                        int r = p.r, c = p.c;
                        cellCount++;
                        if (r == 0 || r == n - 1 || c == 0 || c == m - 1) {
                            touchesBoundary = true;
                        }
                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                                !vis[nr][nc] && grid[nr][nc] == 1) {
                                vis[nr][nc] = true;
                                q.add(new Pair(nr, nc));
                            }
                        }
                    }
                    if (!touchesBoundary) {
                        totalEnclaveCells += cellCount;
                    }
                }
            }
        }
        return totalEnclaveCells;
    }
}
