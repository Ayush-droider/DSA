class Solution {
    Integer[] dp;
    public int rob(int[] nums) {
        dp=new Integer[nums.length+1];
        return helper(0,nums,dp);
    }
    private int helper(int idx,int[] nums,Integer[] dp){

        if(idx>=nums.length)return 0;

        if(idx==nums.length-1)return nums[idx];

        if(dp[idx]!=null)return dp[idx];

        int nochori=0+helper(idx+1,nums,dp);
        int chori=nums[idx]+helper(idx+2,nums,dp);

        return dp[idx]=Math.max(chori,nochori);
    }
}