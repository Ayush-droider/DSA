class Solution {
    public int kadaneMin(int[] nums, int n){
        int sum=nums[0],minSum=nums[0];
        for(int i=1;i<n;i++){
            sum=Math.min(nums[i]+sum,nums[i]);
            minSum=Math.min(sum,minSum);
        }
        return minSum;
    }
    public int kadaneMax(int[] nums, int n){
        int sum=nums[0],maxSum=nums[0];
        for(int i=1;i<n;i++){
            sum=Math.max(nums[i]+sum,nums[i]);
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int Sum=0;
        for(int num:nums){
            Sum+=num;
        }
        int minSum=kadaneMin(nums,n);
        int maxSum=kadaneMax(nums,n);
        int circSum=Sum-minSum;
        if(maxSum>0)return Math.max(maxSum,circSum);
        return maxSum;
    }
}