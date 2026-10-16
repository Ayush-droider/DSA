
class Solution {
    private void swap(int i, int j, int[] nums) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void moveZeroes(int[] nums) {
        int i=0;

        for(int j=0; j<nums.length; j++){
            if(nums[j]!=0){
                swap(i,j,nums);
                i++;
            }
        }
    }
}
