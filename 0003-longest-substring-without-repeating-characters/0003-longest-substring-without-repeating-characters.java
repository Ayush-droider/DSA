class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int n=s.length();
        int len=0;
        HashMap<Character,Integer> map=new HashMap<>();

        while(j<n){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.size()<(j-i+1)){
                char leftch=s.charAt(i);
                map.put(leftch,map.get(leftch)-1);
                if(map.get(leftch)==0)map.remove(leftch);
                i++;
            }
            if((j-i+1)==map.size()){
                len=Math.max(len,j-i+1);
            }
            j++;
        }
        return len;
    }
}