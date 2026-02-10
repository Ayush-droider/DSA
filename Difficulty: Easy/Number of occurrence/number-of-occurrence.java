class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int start=binSearchFirst(arr,target);
        if(start==-1)return 0;
        int end=binSearchEnd(arr,target);
        return end-start+1;
    }
    public int binSearchFirst(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                ans=mid;
                end=mid-1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else start=mid+1;
        }
        return ans;
    }
    public int binSearchEnd(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                ans=mid;
                start=mid+1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else start=mid+1;
        }
        return ans;
    }
}
