class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        HashMap<Character,Character> map=new HashMap<>();
        
        for(int i=0;i<s1.length();i++){
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            if(map.containsKey(ch1)){
                if(map.get(ch1)==ch2)continue;
                else return false;
            }
            else map.put(ch1,ch2);
        }
        
        HashMap<Character,Character> map1=new HashMap<>();
        
        for(int i=0;i<s2.length();i++){
            char ch2=s2.charAt(i);
            char ch1=s1.charAt(i);
            if(map1.containsKey(ch2)){
                if(map1.get(ch2)==ch1)continue;
                else return false;
            }
            else map1.put(ch2,ch1);
        }
        
        return true;
    }
}
        
        
        
        
        
        