class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        dp=new Integer[1001][1001];
        return helper(s,t,0,0,dp);
    }

    private int helper(String s,String t,int i,int j,Integer[][] dp){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        if(dp[i][j]!=null)return dp[i][j];
        int count = 0;
        count+=helper(s,t,i+1,j,dp);
        if(s.charAt(i)==t.charAt(j)){
            count+=helper(s,t,i+1,j+1,dp);
        }
        return dp[i][j]=count;
    }
}