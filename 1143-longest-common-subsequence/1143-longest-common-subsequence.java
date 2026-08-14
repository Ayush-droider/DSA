class Solution {
    Integer[][] dp;
    private int helper(int i,int j,String s1,String s2,Integer[][] dp){
        if(i>=s1.length() || j>=s2.length())return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))return dp[i][j]=1+helper(i+1,j+1,s1,s2,dp);
        return dp[i][j]=Math.max(helper(i+1,j,s1,s2,dp),helper(i,j+1,s1,s2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        dp=new Integer[1001][1001];
        if(text1.equals(text2))return text1.length();
        return helper(0,0,text1,text2,dp);
    }
}