class Solution {
    Integer[] dp;
    private boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public int minCut(String s) {
        dp=new Integer[2001];
        return helper(0,s,Integer.MAX_VALUE,dp);
    }
    private int helper(int idx,String s,int mini,Integer[] dp){

        if(idx==s.length())return -1;

        if(dp[idx]!=null)return dp[idx];

        for(int start=idx;start<s.length();start++){
            if(isPalindrome(s.substring(idx,start+1))){
                mini=Math.min(mini,1+helper(start+1,s,mini,dp));
            }    
        }
        return dp[idx]=mini;
    }
}