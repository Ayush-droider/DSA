class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];   
        int[] arr1 = new int[n-1];   
        int[] arr2 = new int[n-1];   
        for(int i=1;i<n;i++){
            arr1[i-1] = nums[i];
        }
        for(int i=0;i<n-1;i++){
            arr2[i] = nums[i];
        }
        return Math.max(helper(arr1), helper(arr2));
    }

    public int helper(int[] arr){
        int prev = arr[0];
        int prev2 = 0;
        for(int i=1;i<arr.length;i++){
            int steal = arr[i] + prev2;
            int nosteal = prev;
            int curr = Math.max(steal, nosteal);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}