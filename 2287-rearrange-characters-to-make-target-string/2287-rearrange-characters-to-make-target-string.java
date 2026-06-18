class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(char ch:s.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(char ch:target.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        int min=Integer.MAX_VALUE;
        for(char ch:target.toCharArray()){
            min=Math.min(min,map1.getOrDefault(ch,0)/map2.get(ch));
        }
        return min;
    }
}