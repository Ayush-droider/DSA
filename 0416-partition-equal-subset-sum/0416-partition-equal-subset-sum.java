class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum%2==1)return false;
        int k=totalSum/2;
        Boolean[][] dp=new Boolean[201][k+1];
        return helper(0,k,nums,dp);
    }
    private boolean helper(int idx,int target,int[] nums,Boolean[][] dp){

        if(target==0)return true;

        if(idx==nums.length-1)return (nums[idx]==target);

        if(dp[idx][target]!=null)return dp[idx][target];

        boolean notpick=helper(idx+1,target,nums,dp);
        boolean pick=false;
        if(nums[idx]<=target)pick=helper(idx+1,target-nums[idx],nums,dp);

        return dp[idx][target]=pick || notpick;
    }
}