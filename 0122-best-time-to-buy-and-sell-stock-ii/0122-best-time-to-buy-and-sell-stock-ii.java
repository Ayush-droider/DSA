class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int[] rows:dp)Arrays.fill(rows,-1);
        return helper(0, prices, 1,dp);
    }

    public int helper(int idx, int[] values, int buy,int[][] dp) {
        if (idx == values.length) return 0;

        int profit = 0;
        if(dp[idx][buy]!=-1)return dp[idx][buy];
        if (buy == 1) {
            int take = -values[idx] + helper(idx + 1, values, 0,dp);
            int notTake = 0 + helper(idx + 1, values, 1,dp);
            profit = Math.max(take, notTake);
        } else {
            int take = values[idx] + helper(idx + 1, values, 1,dp);
            int notTake = 0 + helper(idx + 1, values, 0,dp);
            profit = Math.max(take, notTake);
        }

        return dp[idx][buy]=profit;
    }
}
