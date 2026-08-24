class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:jewels.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int cnt=0;
        for(char key:stones.toCharArray()){
            if(map.containsKey(key))cnt++;
        }
        return cnt;
    }
}