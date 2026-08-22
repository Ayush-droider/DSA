class Solution {
    public int longCommSubstr(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        
        int[][] dp=new int[n+1][m+1];
        int ans=0;
        
        for(int row=0;row<n;row++){
            dp[row][0]=0;
        }
        
        for(int col=0;col<m;col++){
            dp[0][col]=0;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans=Math.max(dp[i][j],ans);
                }
                else dp[i][j]=0;
            }
        }
        return ans;
    }
}