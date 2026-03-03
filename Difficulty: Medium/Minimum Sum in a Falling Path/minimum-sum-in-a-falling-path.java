class Solution {
    public int minFallingPathSum(int[][] mat) {
        // code here
        int m=mat.length;
        int n=mat[0].length;
        int[][] dp=new int[m][n];
        for(int[] row:dp)Arrays.fill(row,-1);
        int mini=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            mini=Math.min(mini,helper(m-1,j,mat,dp));
        }
        return mini;
    }
    public int helper(int i,int j,int[][] mat,int[][] dp){
        if(j<0 || j>=mat[0].length)return Integer.MAX_VALUE;
        
        if(i==0)return mat[0][j];
        
        if(dp[i][j]!=-1)return dp[i][j];
        
        int u=helper(i-1,j,mat,dp);
        int l=helper(i-1,j-1,mat,dp);
        int ul=helper(i-1,j+1,mat,dp);
        
        return dp[i][j]=mat[i][j]+Math.min(u,Math.min(l,ul));
    }
}
