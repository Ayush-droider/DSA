class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0;
        int n=s.length();
        int maxi=0,maxFreq=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<n){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,map.get(ch));

            if(((j-i+1)-maxFreq)<=k){
                maxi=Math.max(maxi,j-i+1);
            }

            while(((j-i+1)-maxFreq)>k){
                char left=s.charAt(i);
                map.put(left,map.get(left)-1);
                if(map.get(left)==0)map.remove(left);
                i++;
            }
            j++;
        }
        return maxi;
    }
}