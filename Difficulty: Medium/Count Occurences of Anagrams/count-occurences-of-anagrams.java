// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int i=0,j=0;
        int n=txt.length();
        int k=pat.length();
        
        HashMap<Character,Integer> map=new HashMap<>(); 
        for(char ch:pat.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        int count=map.size();
        
        int ans=0;
        
        while(j<n){
            char ch=txt.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)count--;
            }
            
            if((j-i+1)==k){
                if(count==0)ans++;
                
                char leftChar=txt.charAt(i);
                if(map.containsKey(leftChar)){
                    map.put(leftChar,map.get(leftChar)+1);
                    if(map.get(leftChar)==1)count++;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}