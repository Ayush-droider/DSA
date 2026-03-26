// User function Template for Java

class Solution {
    static int characterReplacement(String s, int k) {
        // code here
        HashMap<Character, Integer> map=new HashMap<>();
        int i=0,j=0;
        int n=s.length();
        int maxi=0;
        int maxFreq=0;
        
        while(j<n){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            
            maxFreq=Math.max(maxFreq,map.get(ch));
            
            int condition=(j-i+1)-maxFreq;
            
            while((j-i+1-maxFreq)>k){
                char ich=s.charAt(i);
                map.put(ich,map.get(ich)-1);
                if(map.get(ich)==0)map.remove(ich);
                i++;
            }
            
            if(condition<=k){
                maxi=Math.max(maxi,(j-i+1));
            }
            j++;
        }
        return maxi;
    }
}
