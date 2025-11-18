class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = -nums[i];
            twoSum(nums, i + 1, nums.length - 1, target, nums[i], result);
        }
        return result;
    }

    private void twoSum(int[] nums, int left, int right, int target, int fixed, List<List<Integer>> result) {

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                result.add(Arrays.asList(fixed, nums[left], nums[right]));

                left++;
                right--;

                // skip duplicate values
                while (left < right && nums[left] == nums[left - 1]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }
    }
}
