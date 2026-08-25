class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[501][501];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return helper(0,0,word1,word2,dp);
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