class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int remaining = sum % k;
            if (map.containsKey(remaining)) {
                if (i - map.get(remaining) >= 2) return true;
            } else {
                map.put(remaining, i);
            }
        }
        return false;
    }
}
