class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxi=Integer.MIN_VALUE;
        for(int num:nums){
            if(num==1){
                count++;
                maxi=Math.max(maxi,count);
            }
            else count=0;
        }
        return (maxi==Integer.MIN_VALUE)?0:maxi;
    }
}