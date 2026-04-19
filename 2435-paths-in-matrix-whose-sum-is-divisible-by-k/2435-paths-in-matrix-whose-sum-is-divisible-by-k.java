class Solution {
    int MOD=1000000007;
    Integer[][][] dp;
    public int numberOfPaths(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new Integer[n][m][k];
        return helper(0,0,grid,k,0,dp);
    }
    private int helper(int i,int j,int[][] grid,int k,int sum,Integer[][][] dp){
        if(i>=grid.length || j>=grid[0].length)return 0;

        sum=(sum+grid[i][j])%k;

        if(i==grid.length-1 && j==grid[0].length-1){
            if(sum%k==0)return 1;
            else return 0;
        }

        if(dp[i][j][sum]!=null)return dp[i][j][sum];

        int down=helper(i+1,j,grid,k,sum,dp);
        int right=helper(i,j+1,grid,k,sum,dp);

        return dp[i][j][sum]=(down+right)%MOD;
    }
}