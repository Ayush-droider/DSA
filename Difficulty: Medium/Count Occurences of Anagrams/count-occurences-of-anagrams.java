// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int k=pat.length();
        int size=txt.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<k;i++){
            char ch=pat.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int ans=0;
        int count=map.size();
        int i=0,j=0;
        while(j<size){
            if(map.containsKey(txt.charAt(j))){
                map.put(txt.charAt(j),map.get(txt.charAt(j))-1);
                if(map.get(txt.charAt(j))==0){
                    count--;
                }
            }
            if((j-i+1)<k){
                j++;
            }
            else if((j-i+1)==k){
                if(count==0){
                    ans++;
                }
                if(map.containsKey(txt.charAt(i))){
                    map.put(txt.charAt(i),map.get(txt.charAt(i))+1);
                    if(map.get(txt.charAt(i))==1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}