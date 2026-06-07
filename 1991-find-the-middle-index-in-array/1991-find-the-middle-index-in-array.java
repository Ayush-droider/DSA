class Solution {
    private int getleftSum(int start,int end,int[] nums){
        int sum=0;
        for(int i=start;i<end;i++){
            sum+=nums[i];
        }
        return sum;
    }
    private int getrightSum(int start,int end,int[] nums){
        int sum=0;
        for(int i=start;i<end;i++){
            sum+=nums[i];
        }
        return sum;
    }
    public int findMiddleIndex(int[] nums) {
        int leftSum=0,rightSum=0;
        for(int i=0;i<nums.length;i++){
            leftSum=getleftSum(0,i,nums);
            rightSum=getrightSum(i+1,nums.length,nums);
            if(leftSum==rightSum)return i;
        }
        return -1;
    }
}