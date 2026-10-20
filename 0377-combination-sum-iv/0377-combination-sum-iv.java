class Solution {
    Integer[] dp=new Integer[1001];
    public int combinationSum4(int[] nums, int target) {
        return helper(nums,target);
    }

    private int helper(int[] nums, int target){
        if(target<0)return 0;
        if(target==0){
            return 1;
        }
        if(dp[target]!=null)return dp[target];
        int cnt=0;
        for(int num:nums){
            if(num<=target){
                cnt+=helper(nums,target-num);
            }
        }
        return dp[target]=cnt;
    }
}
