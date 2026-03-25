class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int i=0,j=0;
        int sum=0;
        int n=arr.length;
        int maxi=Integer.MIN_VALUE;
        while(j<n){
            sum+=arr[j];
            if((j-i+1)<k)j++;
            else if((j-i+1)==k){
                maxi=Math.max(maxi,sum);
                j++;
                sum-=arr[i];
                i++;
            }
        }
        return maxi;
    }
}