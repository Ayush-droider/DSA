class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long[] prev = new long[m];

        for (int i = 0; i < n; i++) {
            long[] curr = new long[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[0][0];
                } else {
                    long up = (i > 0) ? prev[j] + grid[i][j] : Long.MAX_VALUE;
                    long left = (j > 0) ? curr[j - 1] + grid[i][j] : Long.MAX_VALUE;
                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }

        return (int) prev[m - 1];
    }
}
