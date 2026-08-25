class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[501][501];
        for(int i=0; i<=n; i++){
            dp[i][0]=i;
        }
        for(int j=0; j<=m; j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int insert=1+dp[i-1][j];
                    int update=1+dp[i][j-1];
                    int replace=1+dp[i-1][j-1];

                    dp[i][j]=Math.min(insert,Math.min(update,replace));
                }
            }
        }
        return dp[n][m];
        // for(int[] d:dp){
        //     Arrays.fill(d,-1);
        // }
        // return helper(0,0,word1,word2,dp);
    }
    private int helper(int i,int j,String word1,String word2,int[][] dp){

        if(i==word1.length())return word2.length()-j;

        if(j==word2.length())return word1.length()-i;

        if(dp[i][j]!=-1)return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j)){
            return helper(i+1,j+1,word1,word2,dp);
        }
        else{
            int insert=1+helper(i+1,j,word1,word2,dp);
            int update=1+helper(i,j+1,word1,word2,dp);
            int replace=1+helper(i+1,j+1,word1,word2,dp);

            return dp[i][j]=Math.min(insert,Math.min(update,replace));
        }
    }
}