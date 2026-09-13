class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] freq = new int[26];
        Map<Character, Integer> map=new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);

            if(map.containsKey(ch)){
                freq[ch-'a']=i-map.get(ch)-1;
                if(freq[ch-'a']!=distance[ch-'a']){
                    return false;
                }
            }
            map.putIfAbsent(ch, i);
        }
        return true;
    }
}