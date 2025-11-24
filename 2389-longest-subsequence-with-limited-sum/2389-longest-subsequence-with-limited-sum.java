class Solution {
    public int binarySearch(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]<=target){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans+1;
    }
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        int[] ans=new int[queries.length];
        int idx=0;
        for(int target:queries){
            int len=binarySearch(nums,target);
            ans[idx]=len;
            idx++;
        }
        return ans;
    }
}