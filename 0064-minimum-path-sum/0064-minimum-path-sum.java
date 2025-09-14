class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] dp = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];  
                } else {
                    long up = (i > 0) ? dp[i - 1][j] + grid[i][j] : Long.MAX_VALUE;
                    long left = (j > 0) ? dp[i][j - 1] + grid[i][j] : Long.MAX_VALUE;
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return (int) dp[n - 1][m - 1];
    }
}
