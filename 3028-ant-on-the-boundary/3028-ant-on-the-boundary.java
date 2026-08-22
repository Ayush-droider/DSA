class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int x=0,count=0;
        for(int num:nums){
            x+=num;
            if(x==0)count++;
        }
        return count;
    }
}