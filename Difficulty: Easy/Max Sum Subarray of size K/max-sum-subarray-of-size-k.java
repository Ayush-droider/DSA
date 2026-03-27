class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int i=0,j=0;
        int sum=0,ans=0;
        int n=arr.length;
        while(j<n){
            sum+=arr[j];
            
            if(j-i+1==k){
                ans=Math.max(ans,sum);
                
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return ans;
    }
}