class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int i = 0;
        int j = 0;
        int n=arr.length;
        int ans=Integer.MIN_VALUE;
        int sum=0;
        while(j<n){
            sum+=arr[j];
            if((j-i+1)<k){
                j++;
            }
            else if((j-i+1)==k){
                ans=Math.max(ans,sum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return ans;
    }
}