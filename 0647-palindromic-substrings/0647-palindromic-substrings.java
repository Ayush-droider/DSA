class Solution {
    public int countSubstrings(String s) {
        boolean dp[][]=new boolean[1001][1001];
        int count=0;
        for(int L=1;L<=s.length();L++){
            for(int i=0;i+L-1<s.length();i++){
                int j=i+L-1;
                if(i==j)dp[i][j]=true;
                else if(i+1==j)dp[i][j]=(s.charAt(i)==s.charAt(j));
                else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true);
                }
                if(dp[i][j]==true)count++;
            }
        }
        return count;
    }
}