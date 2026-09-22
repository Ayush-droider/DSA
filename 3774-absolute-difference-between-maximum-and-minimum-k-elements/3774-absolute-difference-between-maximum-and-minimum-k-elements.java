class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int small=0,large=0;
        for(int i=0;i<k;i++){
            small+=nums[i];
            large+=nums[nums.length-i-1];
        }
        return Math.abs(small-large);
    }
}