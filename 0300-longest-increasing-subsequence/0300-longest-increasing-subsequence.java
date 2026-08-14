class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp=new Integer[2501][2501];
        return helper(0,-1,nums,dp);
    }

    private int helper(int idx,int prev,int[] nums,Integer[][] dp){
        if(idx==nums.length)return 0;
        if(dp[idx][prev+1]!=null)return dp[idx][prev+1];
        int take=0;
        if(prev==-1 || nums[idx]>nums[prev]){
            take= 1+helper(idx+1,idx,nums,dp);
        }
        int nottake=0+helper(idx+1,prev,nums,dp);
        return dp[idx][prev+1]=Math.max(take,nottake);
    }
}