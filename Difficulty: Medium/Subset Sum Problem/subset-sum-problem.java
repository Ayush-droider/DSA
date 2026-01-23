class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; i++)
            dp[i][0] = true;
        if (arr[0] <= sum)
            dp[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= sum; target++) {
                boolean notPick = dp[i - 1][target];
                boolean pick = false;
                if (arr[i] <= target)
                    pick = dp[i - 1][target - arr[i]];
                dp[i][target] = pick || notPick;
            }
        }
        return dp[n - 1][sum];
    }
}
