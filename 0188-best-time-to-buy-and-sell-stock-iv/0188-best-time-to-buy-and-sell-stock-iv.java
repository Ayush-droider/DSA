class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][k+1];
        return helper(0, 1, k, prices, dp);
    }

    private int helper(int idx, int buy, int cap, int[] prices, Integer[][][] dp) {
        if (idx == prices.length || cap == 0) return 0;
        if (dp[idx][buy][cap] != null) return dp[idx][buy][cap];

        int profit;
        if (buy == 1) {
            int buyNow = -prices[idx] + helper(idx + 1, 0, cap, prices, dp);
            int skip = helper(idx + 1, 1, cap, prices, dp);
            profit = Math.max(buyNow, skip);
        } else {
            int sellNow = prices[idx] + helper(idx + 1, 1, cap - 1, prices, dp);
            int skip = helper(idx + 1, 0, cap, prices, dp);
            profit = Math.max(sellNow, skip);
        }

        return dp[idx][buy][cap] = profit;
    }
}
