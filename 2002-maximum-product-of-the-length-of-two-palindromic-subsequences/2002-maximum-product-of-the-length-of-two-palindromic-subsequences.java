class Solution {
    int ans=0;
    public int maxProduct(String s) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        helper(0,sb1,sb2,s);
        return ans;
    }
    private void helper(int idx,StringBuilder sb1,StringBuilder sb2,String s){
        if(idx==s.length()){
            if(isPal(sb1) && isPal(sb2)){
                ans=Math.max(ans,sb1.length()*sb2.length());
            }
            return ;
        }
        helper(idx+1,sb1.append(s.charAt(idx)),sb2,s);
        helper(idx+1,sb1.deleteCharAt(sb1.length()-1),sb2.append(s.charAt(idx)),s);
        helper(idx+1,sb1,sb2.deleteCharAt(sb2.length()-1),s);
    }
    private boolean isPal(StringBuilder s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}