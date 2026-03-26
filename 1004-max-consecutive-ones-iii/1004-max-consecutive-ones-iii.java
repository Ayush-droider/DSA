class Solution {
    public int longestOnes(int[] nums, int k) {
       int i=0,j=0;
       int n=nums.length;
       int flip=0;
       int maxi=0;

       while(j<n){
        if(nums[j]==0){
            flip++;
        }

        while(flip>k){
            if(nums[i]==0){
                flip--;
            }
            i++;
        }

        if(flip<=k){
            maxi=Math.max(j-i+1,maxi);
        }
        j++;
       } 
       return maxi;
    }
}