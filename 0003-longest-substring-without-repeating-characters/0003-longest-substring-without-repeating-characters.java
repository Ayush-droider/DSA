class Solution {
    //agar map ka size tere window ki size se chhota hai matlab repeated
    //character hai tabtak hata jab tak jyada hai agar mapsize==window size
    //.............................FUCKED.................................
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int maxi=Integer.MIN_VALUE;
        Map<Character,Integer> map=new HashMap<>();
        int ans=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);

            if(map.size()==(j-i+1))ans=Math.max(ans,(j-i+1));

            while(map.size()<(j-i+1)){
                char left=s.charAt(i);
                map.put(left,map.get(left)-1);
                if(map.get(left)==0)map.remove(left);
                i++;
            }
            j++;
        }
        return ans;
    }
}