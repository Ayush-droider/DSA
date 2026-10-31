class Solution {
    public int maxPower(String s) {
        char curr='1';
        int i=0,j=0,ans=0;
        while(j<s.length()){
            if(curr!=s.charAt(j))i=j;
            curr=s.charAt(j);
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}