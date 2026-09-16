class Solution {
    public int balancedStringSplit(String s) {
        int j=0;
        int n=s.length();
        int r=0,l=0;
        int maxi=0;
        while(j<n){
            if(s.charAt(j)=='R')r++;
            else l++;

            if(l==r){
                maxi++;
            }
            j++;
        }
        return maxi;
    }
}