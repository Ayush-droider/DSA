class Solution {
    Integer[][] dp;
    public boolean stoneGame(int[] piles) {
        dp=new Integer[piles.length][piles.length];
        return helper(0,piles.length-1,piles,dp)>=0;
    }
    private int helper(int i,int j,int[] piles,Integer[][] dp){
        if(i==j)return piles[j];
        if(dp[i][j]!=null)return dp[i][j];
        int pickleft=piles[i]+helper(i+1,j,piles,dp);
        int pickright=piles[j]+helper(i,j-1,piles,dp);
        return dp[i][j]=Math.max(pickleft,pickright);
    }
}