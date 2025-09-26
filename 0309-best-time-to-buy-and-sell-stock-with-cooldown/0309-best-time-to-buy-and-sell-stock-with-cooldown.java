import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(0, 1, prices, dp);
    }

    private int helper(int idx, int buy, int[] prices, int[][] dp) {
        if (idx >= prices.length) return 0;
        if (dp[idx][buy] != -1) return dp[idx][buy];

        if (buy == 1) {
            int buyNow = -prices[idx] + helper(idx + 1, 0, prices, dp);
            int skip = helper(idx + 1, 1, prices, dp);
            return dp[idx][buy] = Math.max(buyNow, skip);
        } else {
            int sellNow = prices[idx] + helper(idx + 2, 1, prices, dp); 
            int skip = helper(idx + 1, 0, prices, dp);
            return dp[idx][buy] = Math.max(sellNow, skip);
        }
    }
}
