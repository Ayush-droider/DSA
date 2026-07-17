class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0,flips=0;
        int ans=0,maxi=Integer.MIN_VALUE;
        while(j<nums.length){


            if(nums[j]==0)flips++;

            while(flips>k){
                if(nums[i]==0)flips--;
                i++;
            }
            ans=j-i+1;
            maxi=Math.max(ans,maxi);
            j++;
        }
        return maxi;
    }
}