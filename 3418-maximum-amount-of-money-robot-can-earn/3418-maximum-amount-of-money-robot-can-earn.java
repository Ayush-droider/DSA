class Solution {
    Integer[][][] dp;

    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        dp = new Integer[n][m][3];
        return solve(0, 0, 2, coins);
    }

    private int solve(int i, int j, int neu, int[][] coins) {
        if (i >= coins.length || j >= coins[0].length)
            return Integer.MIN_VALUE;
        if (dp[i][j][neu] != null)
            return dp[i][j][neu];
        if (i == coins.length - 1 && j == coins[0].length - 1) {
            if (coins[i][j] < 0 && neu > 0)
                return dp[i][j][neu] = 0;
            return dp[i][j][neu] = coins[i][j];
        }
        int down = solve(i + 1, j, neu, coins);
        int right = solve(i, j + 1, neu, coins);
        int take = coins[i][j] + Math.max(down, right);
        int skip = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && neu > 0) {
            int skipDown = solve(i + 1, j, neu - 1, coins);
            int skipRight = solve(i, j + 1, neu - 1, coins);
            skip = Math.max(skipDown, skipRight);
        }
        return dp[i][j][neu] = Math.max(take, skip);
    }
}