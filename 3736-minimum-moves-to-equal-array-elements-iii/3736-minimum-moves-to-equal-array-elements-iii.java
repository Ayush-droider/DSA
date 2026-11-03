class Solution {
    private int maxmum(int[] nums){
        int maxi=Integer.MIN_VALUE;
        for(int num:nums){
            maxi=Math.max(num,maxi);
        }
        return maxi;
    }
    public int minMoves(int[] nums) {
        int max=maxmum(nums);
        int count=0;
        for(int num:nums){
            count+=max-num;
        }
        return count;
    }
}