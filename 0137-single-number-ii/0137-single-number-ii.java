class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int key=e.getKey();
            int val=e.getValue();

            if(val%3!=0)return key;
        }
        return -1;
    }
}