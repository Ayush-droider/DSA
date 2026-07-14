class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int maxi=Integer.MIN_VALUE,ans=0,flip=0;
        while(j<nums.length){
            if(nums[j]==0)flip++;
            while(flip>k){
                if(nums[i]==0)flip--;
                i++;
            }
            ans=j-i+1;
            maxi=Math.max(maxi,ans);
            j++;
        }
        return maxi;
    }
}