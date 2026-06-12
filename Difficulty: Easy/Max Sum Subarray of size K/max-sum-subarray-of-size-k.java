class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int i=0,j=0;
        int sum=0;
        int maxi=Integer.MIN_VALUE;
        while(j<arr.length){
            sum+=arr[j];
            if((j-i+1)==k){
                maxi=Math.max(maxi,sum);
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return maxi;
    }
}