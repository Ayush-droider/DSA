class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] premax=new int[nums.length];
        premax[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            premax[i]=Math.max(nums[i],premax[i-1]);
        }
        int[] suffmin=new int[nums.length];
        suffmin[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suffmin[i]=Math.min(nums[i],suffmin[i+1]);
        }
        for(int i=0;i<nums.length;i++){
            if(premax[i]-suffmin[i]<=k)return i;
        }
        return -1;
    }
}