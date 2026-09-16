class Solution {
    public int balancedStringSplit(String s) {
        int len=s.length();
        int r=0,l=0,ans=0;
        for(int i=0;i<len;i++)
        {
            if(s.charAt(i)=='R')
            r++;
            else
            l++;

            if(r==l){
            ans++;
            r=0;
            l=0;
            }

        }
        return ans;
        
    }
}