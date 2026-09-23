class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans=0;
        HashSet<String> seen=new HashSet<>();
        for(int i=0;i<words.length;i++){
            String temp=new String(words[i]);
            StringBuilder sb=new StringBuilder(words[i]);
            sb.reverse();
            String s=sb.toString();
            if(seen.contains(s) || seen.contains(temp)){
                ans++;
            }
            seen.add(s);
            seen.add(temp);
        }
        return ans;
    }
}