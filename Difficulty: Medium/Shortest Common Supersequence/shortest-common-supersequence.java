class Solution {
    public static int minSuperSeq(String s1, String s2) {
        // code here
        // return helper(0,0,s1,s2);
        int[][] dp=new int[501][501];
        int n=s1.length();
        int m=s2.length();
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=1+Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    private static int helper(int i,int j,String s1,String s2){
        if(i == s1.length())return s2.length() - j;
        if(j == s2.length())return s1.length() - i;
        if(i==s1.length() || j==s2.length())return i+j;
        if(s1.charAt(i)==s2.charAt(j))return 1+helper(i+1,j+1,s1,s2);
        else return 1+Math.min(helper(i+1,j,s1,s2),helper(i,j+1,s1,s2));
    }
}