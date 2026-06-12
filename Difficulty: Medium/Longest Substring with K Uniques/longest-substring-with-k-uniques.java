class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int i=0,j=0;
        Map<Character,Integer> map=new HashMap<>();
        int ans=Integer.MIN_VALUE;
        
        while(j<s.length()){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            if(map.size()==k){
                ans=Math.max(ans,(j-i+1));
            }
        
            while(map.size()>k){
                char left=s.charAt(i);
                map.put(left,map.get(left)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
                i++;
            }
            j++;
        }
        return (ans==Integer.MIN_VALUE)?-1:ans;
    }
}