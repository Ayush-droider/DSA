class Solution {
    public int maxSubArray(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        for(int num:nums){
            sum+=num;
            maxi=Math.max(sum,maxi);
            if(sum<0)sum=0;
        }
        return maxi;
    }
}