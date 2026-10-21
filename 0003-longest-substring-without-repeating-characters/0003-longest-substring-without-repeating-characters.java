class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int i=0,j=0;
        int n=s.length();
        int ans=0;
        while(j<n){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            while(map.size()<(j-i+1)){
                char ch=s.charAt(i);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)map.remove(ch);
                i++;
            }
            if(map.size()==(j-i+1))ans=Math.max(ans,(j-i+1));
            j++;
        }
        return ans;
    }
}