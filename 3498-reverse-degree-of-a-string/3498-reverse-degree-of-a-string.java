class Solution {
    public int reverseDegree(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int a=26;
        for(char ch='a';ch<='z';ch++){
            map.put(ch,a);
            a-=1;
        }
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            ans+=map.get(ch)*(i+1);
        }
        return ans;
    }
}