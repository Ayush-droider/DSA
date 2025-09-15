class Solution {
    public boolean canPartition(int[] nums) {
        int totsum = 0;
        for (int num : nums) {
            totsum += num;
        }

        if (totsum % 2 == 1) return false;

        int k = totsum / 2;
        int n = nums.length;

        Boolean[][] dp = new Boolean[n][k + 1];
        return helper(n - 1, k, nums, dp);
    }

    public boolean helper(int idx, int target, int[] nums, Boolean[][] dp) {
        if (target == 0) return true;
        if (idx == 0) return nums[0] == target;

        if (dp[idx][target] != null) return dp[idx][target];

        boolean nottake = helper(idx - 1, target, nums, dp);
        boolean take = false;
        if (nums[idx] <= target) {
            take = helper(idx - 1, target - nums[idx], nums, dp);
        }

        return dp[idx][target] = (nottake || take);
    }
}
