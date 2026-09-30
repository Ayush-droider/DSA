class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;

        int[] suffix = new int[n];

        suffix[n - 1] = nums[n - 1];

        int sum = nums[n - 1];
        int count = 1;

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = sum / count;

            sum += nums[i];
            count++;
        }

        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > suffix[i]) {
                ans++;
            }
        }

        return ans;
    }
}