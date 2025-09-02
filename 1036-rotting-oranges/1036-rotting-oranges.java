class Solution {
    private class Pair {
        int r, c, tm;
        public Pair(int r, int c, int tm) {
            this.r = r;
            this.c = c;
            this.tm = tm;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        int countFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                } else {
                    visited[i][j] = false;
                }
                if (grid[i][j] == 1) {
                    countFresh++;
                }
            }
        }

        int time = 0;
        int rottenCount = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int ro = p.r;
            int co = p.c;
            int t = p.tm;
            time = Math.max(time, t);

            for (int k = 0; k < 4; k++) {
                int nrow = ro + delrow[k];
                int ncol = co + delcol[k];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && grid[nrow][ncol] == 1 && !visited[nrow][ncol]) {
                    q.add(new Pair(nrow, ncol, t + 1));
                    visited[nrow][ncol] = true;
                    rottenCount++;
                }
            }
        }

        if (rottenCount == countFresh) return time;
        return -1;
    }
}
