class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Integer[][] dp=new Integer[201][201];
        return helper(0,0,n,m,grid,dp);
    }
    private int helper(int i,int j,int n,int m,int[][] grid,Integer[][] dp){
        if(i<0 || i>=n || j<0 || j>=m)return Integer.MAX_VALUE;
        if(i==n-1 && j==m-1)return grid[i][j];

        if(dp[i][j]!=null)return dp[i][j];

        int right=helper(i,j+1,n,m,grid,dp);
        int down=helper(i+1,j,n,m,grid,dp);

        return dp[i][j]=grid[i][j]+Math.min(right,down);
    }
}