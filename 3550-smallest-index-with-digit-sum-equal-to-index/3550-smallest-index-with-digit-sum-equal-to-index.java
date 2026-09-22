class Solution {
    private boolean sumEquals(int num,int i){
        int r=0,sum=0;
        while(num>0){
            r=num%10;
            sum+=r;
            num=num/10;
        }
        return sum==i;
    }
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(sumEquals(nums[i],i)){
                return i;
            }
        }
        return -1;
    }
}