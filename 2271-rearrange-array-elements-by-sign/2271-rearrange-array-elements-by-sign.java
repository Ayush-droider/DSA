class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posIndex=0,negIndex=1;
        int[] ans=new int[nums.length];
        for(int num:nums){
            if(num>0){
                ans[posIndex]=num;
                posIndex+=2;
            }
            else{
                ans[negIndex]=num;
                negIndex+=2;
            }
        }
        return ans;
    }
}