class Solution {
    public boolean checkPalindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int maxLen=0;
        int sp=0;
        int ep=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(checkPalindrome(i,j,s)){
                    if(maxLen<j-i+1){
                        maxLen=j-i+1;
                        sp=i;
                        ep=j;
                    }
                }
            }
        }
        return s.substring(sp,ep+1);
    }
}