class Solution {
    public void nextPermutation(int[] nums) {
        helper(nums, nums.length - 2);
    }

    private void helper(int[] nums, int i) {
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        if (nums[i] < nums[i + 1]) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);   
            reverse(nums, i + 1, nums.length - 1);
        } else {
            helper(nums, i - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        if (i >= j) return;
        swap(nums, i, j);
        reverse(nums, i + 1, j - 1);
    }
}
