class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        int target=totalSum-x;

        int i=0,j=0;
        int sum=0;
        int len=-1;
        while(j<nums.length){
            sum+=nums[j];
            while(i<nums.length && sum>target){
                sum-=nums[i];
                i++;
            }
            if(sum==target){
                len=Math.max(len,j-i+1);
            }
            j++;
        }
        return len==-1?-1:nums.length-len;
    }
}