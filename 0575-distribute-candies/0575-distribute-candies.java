class Solution {
    public int distributeCandies(int[] candyType) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int c:candyType){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int ans=candyType.length/2;
        return map.size()>=ans?ans:map.size();
    }
}