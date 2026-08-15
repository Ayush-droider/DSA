class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        boolean hasOneNoneZero=false;
        for(int num:nums){
            xor^=num;
            if(num!=0)hasOneNoneZero=true;
        }
        if(xor!=0)return nums.length;
        return hasOneNoneZero?nums.length-1:0;
    }
}