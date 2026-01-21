import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int target = nums.get(i);
            int result = -1;

            // Since we need to minimize ans[i], we start from 0.
            // ans[i] will always be less than nums[i].
            for (int x = 0; x < target; x++) {
                if ((x | (x + 1)) == target) {
                    result = x;
                    break; // Found the minimum, move to next num
                }
            }
            ans[i] = result;
        }

        return ans;
    }
}