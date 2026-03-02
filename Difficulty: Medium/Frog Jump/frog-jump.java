class Solution {
    int minCost(int[] height) {
        // code here
        int n=height.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(n-1,height,dp);
    }
    int helper(int idx,int[] height,int[] dp){
        if(idx==0)return 0;
        
        if(dp[idx]!=-1)return dp[idx];
        
        int one=helper(idx-1,height,dp)+Math.abs(height[idx]-height[idx-1]);
        int two=Integer.MAX_VALUE;
        if(idx>=2){
            two=helper(idx-2,height,dp)+Math.abs(height[idx]-height[idx-2]);
        }
        dp[idx]= Math.min(one,two);
        return dp[idx];
    }
}