class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0;
        int sum=0,mini=Integer.MAX_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                mini=Math.min(mini,(j-i+1));
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return (mini==Integer.MAX_VALUE)?0:mini;
    }
}