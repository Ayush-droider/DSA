class Solution {
    Integer[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp=new Integer[days.length];
        return helper(0,days,costs,dp);
    }
    private int helper(int idx, int[] days, int[] costs,Integer[] dp) {
        if (idx >= days.length) return 0;

        if(dp[idx]!=null)return dp[idx];
        
        //1-day Pass
        int cost1=costs[0]+helper(idx+1,days,costs,dp);

        //7 days Pass
        int j=idx;
        int max_day=days[idx]+7;
        while(j<days.length && days[j]<max_day)j++;

        int cost2=costs[1]+helper(j,days,costs,dp);

        //30-days Pass
        j=idx;
        max_day=days[idx]+30;
        while(j<days.length && days[j]<max_day)j++;

        int cost3=costs[2]+helper(j,days,costs,dp);

        return dp[idx]=Math.min(Math.min(cost1,cost2),cost3);
    }
}