class Solution {
    public int longestStrChain(String[] words) {
        Integer[][] dp=new Integer[1001][1001];
        Arrays.sort(words,(a,b)->a.length()-b.length());
        return helper(0,-1,words,dp);
    }

    private int helper(int idx,int prev,String[] words,Integer[][] dp){
        if(idx==words.length)return 0;
        int take=0;
        if(dp[idx][prev+1]!=null)return dp[idx][prev+1];
        if(prev==-1 || isPred(0,0,words[idx],words[prev])){
            take=1+helper(idx+1,idx,words,dp);
        }
        int nottake=helper(idx+1,prev,words,dp);
        return dp[idx][prev+1]=Math.max(take,nottake);
    }

    private boolean isPred(int i, int j, String word1, String word2) {
        if(word1.length()!=word2.length()+1)return false;

        if(j==word2.length())return true;

        if(i==word1.length())return false;

        if(word1.charAt(i)==word2.charAt(j)){
            return isPred(i+1, j+1,word1,word2);
        }
        return isPred(i+1,j,word1,word2);
    }
}