class Solution {
    Boolean[][] dp;
    private boolean helper(int i,int j,String s,String p){
        if(j==p.length())return i==s.length();
        if(dp[i][j]!=null)return dp[i][j];
        if(p.charAt(j)=='*'){
            return dp[i][j]=helper(i,j+1,s,p)||(i<s.length()&&helper(i+1,j,s,p));
        }
        if(i<s.length()&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j))){
            return dp[i][j]=helper(i+1,j+1,s,p);
        }
        return dp[i][j]=false;
    }
    public boolean isMatch(String s,String p){
        dp=new Boolean[s.length()+1][p.length()+1];
        return helper(0,0,s,p);
    }
}