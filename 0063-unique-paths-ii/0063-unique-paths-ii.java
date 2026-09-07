class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer[][] dp=new Integer[101][101];
        return helper(0,0,obstacleGrid.length,obstacleGrid[0].length,obstacleGrid,dp);
    }
    private int helper(int i,int j,int n,int m,int[][] obstacleGrid,Integer[][] dp){
        if(i<0 || i>=n || j<0 || j>=m || obstacleGrid[i][j]==1)return 0;
        if(i==n-1 && j==m-1)return 1;

        if(dp[i][j]!=null)return dp[i][j];

        int right=helper(i,j+1,n,m,obstacleGrid,dp);
        int down=helper(i+1,j,n,m,obstacleGrid,dp);

        return dp[i][j]=right+down;
    }
}