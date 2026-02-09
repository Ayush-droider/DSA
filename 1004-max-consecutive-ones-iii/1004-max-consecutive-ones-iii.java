class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int size=nums.length;
        int maxi=0;
        int flip=0;
        while(j<size){
            if(nums[j]==0){
                flip++;
            }
            if(flip<=k){
                maxi=Math.max(maxi,j-i+1);
                j++;
            }
            
            else if(flip>k){
                while(flip>k){
                    if(nums[i]==0){
                        flip--;
                    }
                    i++;
                }
                j++;
            }
        }
        return maxi;
    }
}