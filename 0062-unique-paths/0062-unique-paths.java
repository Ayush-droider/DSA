class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp=new Integer[101][101];
        // return helper(0,0,m,n,dp);
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                // if(i==m-1 && j==n-1)dp[i][j]=1;
                int down=dp[i-1][j];
                int right=dp[i][j-1];
                dp[i][j]=down+right;
            }
        }
        return dp[m-1][n-1];
    }
    private int helper(int i,int j,int m,int n,Integer[][] dp){
        if(i>=m || i<0 || j<0 || j>=n)return 0;
        if(i==m-1 && j==n-1)return 1;

        if(dp[i][j]!=null)return dp[i][j];

        int down=helper(i+1,j,m,n,dp);
        int right=helper(i,j+1,m,n,dp);

        return dp[i][j]=right+down;
    }
}