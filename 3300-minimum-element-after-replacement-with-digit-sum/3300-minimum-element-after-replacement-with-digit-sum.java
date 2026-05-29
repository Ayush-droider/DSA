class Solution {
    private int sum(int num){
        int r=0;
        int sum=0;
        while(num!=0){
            r=num%10;
            sum+=r;
            num/=10;
        }
        return sum;
    }
    private int getMinimum(int[] nums){
        int smallest=Integer.MAX_VALUE;
        for(int num:nums){
            if(num<smallest)smallest=num;
        }
        return smallest;
    }
    public int minElement(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i]=sum(nums[i]);
        }
        int mini=getMinimum(nums);
        return mini;
    }
}