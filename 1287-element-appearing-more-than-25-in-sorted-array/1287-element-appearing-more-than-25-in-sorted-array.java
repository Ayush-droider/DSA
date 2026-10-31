class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        double cap=0.25;
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int key:map.keySet()){
            if((double)map.get(key)/n>0.25)return key;
        }
        return -1;
    }
}