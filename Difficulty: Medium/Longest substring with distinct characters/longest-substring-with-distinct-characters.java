class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int i=0,j=0;
        int n=s.length();
        
        HashMap<Character,Integer> map=new HashMap<>();
        int maxi=0;
        
        while(j<n){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            while(map.size()<j-i+1){
                char ich=s.charAt(i);
                map.put(ich,map.get(ich)-1);
                if(map.get(ich)==0)map.remove(ich);
                i++;
            }
            
            if(map.size()==j-i+1){
                maxi=Math.max(maxi,j-i+1);
            }
            
            j++;
        }
        
        return maxi;
    }
}