class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0;
        int ans=0,skip=0;
        while(j<nums.length){
            if(nums[j]==0)skip++;
            while(skip>1){
                if(nums[i]==0)skip--;
                i++;
            }
            ans=Math.max(ans,(j-i));
            j++;
        }
        return ans;
    }
}