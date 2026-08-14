class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        dp=new int[2501];
        int maxLen=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    maxLen=Math.max(dp[i],maxLen);
                }
            }
        }
        return maxLen+1;
    }
}