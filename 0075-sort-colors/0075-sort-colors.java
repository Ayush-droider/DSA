class Solution {
    public void swap(int[] arr,int start,int end){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    public void sortColors(int[] nums) {
        int i=0,j=0,k=nums.length-1;
        while(j<=k){
            if(nums[j]==2){
                swap(nums,j,k);
                k--;
            }
            else if(nums[j]==1)j++;
            else{
                swap(nums,i,j);
                j++;
                i++;
            }
        }
    }
}