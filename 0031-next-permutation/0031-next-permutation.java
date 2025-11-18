class Solution {
    public void swap(int[] nums,int start,int end){
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int gola_index=-1;
        for(int i=n-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                gola_index=i-1;
                break;
            }
        }
        int swap_index=gola_index;
        if(swap_index!=-1){
            for(int j=n-1;j>=gola_index+1;j--){
                if(nums[gola_index]<nums[j]){
                    swap_index=j;
                    break;
                }
            }
            swap(nums,gola_index,swap_index);
        }
        reverse(nums,gola_index+1,n-1);
    }
}