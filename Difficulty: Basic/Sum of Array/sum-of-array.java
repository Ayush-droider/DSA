class Solution {
    int arraySum(int arr[]) {
        return helper(arr,arr.length-1);
    }
    int helper(int[] arr,int idx){
        if(idx==0){
            return arr[0];
        }
        return arr[idx]+helper(arr,idx-1);
    }
}
