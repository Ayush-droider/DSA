class Solution {
    private void swap(int[] nums,int start,int end){
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }
    public void sortColors(int[] nums) {
        int i=0,j=0,k=nums.length-1;
        while(j<=k){
            if(nums[j]==0){
                swap(nums,i,j);
                i++;
                j++;
            }
            else if(nums[j]==1)j++;
            else {
                swap(nums,j,k);
                k--;
            }
        }
    }
}