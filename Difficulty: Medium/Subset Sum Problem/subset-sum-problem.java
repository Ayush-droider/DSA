class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        Boolean[][] dp=new Boolean[200][10000];
        return helper(arr.length - 1, arr, sum,dp);
    }

    public static Boolean helper(int idx, int[] arr, int target,Boolean[][] dp) {
        if (target == 0) return true;
        if (idx == 0) return (target == arr[0]);
        
        if(dp[idx][target]!=null)return dp[idx][target];
        
        boolean notpick = helper(idx - 1, arr, target,dp);
        boolean pick = false;
        if (arr[idx] <= target) {
            pick = helper(idx - 1, arr, target - arr[idx],dp);
        }
        return dp[idx][target]=pick || notpick;
    }
}