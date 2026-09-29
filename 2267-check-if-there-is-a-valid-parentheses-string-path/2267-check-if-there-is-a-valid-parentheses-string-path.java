class Solution {
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new Boolean[n][m][n+m];
        if(grid[0][0]==')')return false;
        return helper(0,0,1,grid,n,m,dp);
    }

    private boolean helper(int i,int j,int count,char[][] grid,int n,int m,Boolean[][][] dp) {
        if(i<0||i>=n||j<0||j>=m)return false;
        if(count<0)return false;
        if(i==n-1&&j==m-1){
            if(count==0)return true;
            return false;
        }
        if(dp[i][j][count]!=null)return dp[i][j][count];

        boolean down=false;
        if(i+1<n){
            if(grid[i+1][j]=='('){
                down=helper(i+1,j,count+1,grid,n,m,dp);
            }else{
                down=helper(i+1,j,count-1,grid,n,m,dp);
            }
        }

        boolean right=false;
        if(j+1<m){
            if(grid[i][j+1]=='('){
                right=helper(i,j+1,count+1,grid,n,m,dp);
            }else{
                right=helper(i,j+1,count-1,grid,n,m,dp);
            }
        }

        return dp[i][j][count]=down||right;
    }
}