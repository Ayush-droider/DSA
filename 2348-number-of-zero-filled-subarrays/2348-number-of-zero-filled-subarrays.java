class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n=nums.length;
        int count=0;
        long result=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0)count++;
            else count=0;
            result+=count;
        }
        return result;
    }
}