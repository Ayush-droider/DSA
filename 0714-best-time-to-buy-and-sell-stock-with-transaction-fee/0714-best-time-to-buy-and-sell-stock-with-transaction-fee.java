import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(0, 1, fee, prices, dp);
    }

    private int helper(int idx, int buy, int fee, int[] prices, int[][] dp) {
        if (idx >= prices.length) return 0;
        if (dp[idx][buy] != -1) return dp[idx][buy];

        if (buy == 1) {
            int buyNow = -prices[idx] + helper(idx + 1, 0, fee, prices, dp);
            int skip = helper(idx + 1, 1, fee, prices, dp);
            return dp[idx][buy] = Math.max(buyNow, skip);
        } else {
            int sellNow = prices[idx] - fee + helper(idx + 1, 1, fee, prices, dp);
            int skip = helper(idx + 1, 0, fee, prices, dp);
            return dp[idx][buy] = Math.max(sellNow, skip);
        }
    }
}
