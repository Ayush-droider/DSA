class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(arr.length-1,arr,dp);
    }
    public int helper(int idx,int[] arr,int[] dp){
        if(idx==0)return arr[idx];
        if(idx<0)return 0;
        
        if(dp[idx]!=-1)return dp[idx];
        
        int nosteal=0+helper(idx-1,arr,dp);
        int steal=arr[idx]+helper(idx-2,arr,dp);
        
        return dp[idx]=Math.max(steal,nosteal);
    }
}