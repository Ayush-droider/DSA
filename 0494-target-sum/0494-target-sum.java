class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Integer[][] dp=new Integer[21][2001];
        return helper(0,nums,target,dp);
    }
    private int helper(int idx,int[] nums,int target,Integer[][] dp){
        if(idx>=nums.length){
            if(target==0){
                return 1;
            }
            return 0;
        }

        if(target<-1000 || target>1000){
            return 0;
        }

        if(dp[idx][target+1000]!=null)return dp[idx][target+1000];

        int plus=helper(idx+1,nums,target-nums[idx],dp);
        int minus=helper(idx+1,nums,target+nums[idx],dp);

        return dp[idx][target+1000]=plus+minus;
    }
}