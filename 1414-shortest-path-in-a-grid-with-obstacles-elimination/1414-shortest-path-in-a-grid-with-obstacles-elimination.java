class Solution {
    class Triplet {
        int first;
        int second;
        int kth;
        Triplet(int first, int second, int kth) {
            this.first = first;
            this.second = second;
            this.kth = kth;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        int[][][] vis = new int[n][m][k + 1];

        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(0, 0, k));
        vis[0][0][k] = 1;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Triplet t = q.poll();
                int fir = t.first;
                int sec = t.second;
                int K = t.kth;
                if (fir == n - 1 && sec == m - 1) return steps;

                for (int dir = 0; dir < 4; dir++) {
                    int new_i = fir + delrow[dir];
                    int new_j = sec + delcol[dir];

                    if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= m) continue;

                    if (grid[new_i][new_j] == 0 && vis[new_i][new_j][K] == 0) {
                        vis[new_i][new_j][K] = 1;
                        q.add(new Triplet(new_i, new_j, K));
                    }

                    if (grid[new_i][new_j] == 1 && K > 0 && vis[new_i][new_j][K - 1] == 0) {
                        vis[new_i][new_j][K - 1] = 1;
                        q.add(new Triplet(new_i, new_j, K - 1));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
