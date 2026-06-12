class Solution {
    public int calcBeauty(int i,int j,String s){
        int[] freq=new int[26];

        for(int a=i;a<=j;a++){
            char ch=s.charAt(a);
            freq[ch-'a']++;
        }
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        for(int f:freq){
            if(f>0){
                maxi=Math.max(f,maxi);
                mini=Math.min(f,mini);
            }
        }
        return maxi-mini;
    }
    public int beautySum(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                ans+=calcBeauty(i,j,s);
            }
        }
        return ans;
    }
}