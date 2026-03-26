class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n=arr.length;
        int i=0,j=0;
        int sum=0;
        int maxi=Integer.MIN_VALUE;
        while(j<n){
            sum+=arr[j];
            if((j-i+1)==k){
                maxi=Math.max(sum,maxi);
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return maxi;
    }
}