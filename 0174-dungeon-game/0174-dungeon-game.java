class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        Integer[][] dp=new Integer[201][201];
        return helper(0,0,n,m,dungeon,dp);
    }
    private int helper(int i,int j,int n,int m, int[][] dungeon,Integer[][] dp){
        if(i>=n || j>=m)return Integer.MAX_VALUE;

        if(i==n-1 && j==m-1){
            if(dungeon[i][j]>0)return 1;
            else return Math.abs(dungeon[i][j])+1;
        } 

        if(dp[i][j]!=null)return dp[i][j];

        int down=helper(i+1,j,n,m,dungeon,dp);
        int right=helper(i,j+1,n,m,dungeon,dp);

        int result=Math.min(right,down)-dungeon[i][j];

        return dp[i][j]=result>0?result:1;
    }
}