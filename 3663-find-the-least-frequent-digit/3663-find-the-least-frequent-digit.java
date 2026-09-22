class Solution {
    public int getLeastFrequentDigit(int n) {
        Map<Integer,Integer> map=new HashMap<>();
        int r=0;
        while(n!=0){
            r=n%10;
            n=n/10;
            map.put(r,map.getOrDefault(r,0)+1);
        }
        int maxi=Integer.MAX_VALUE;
        for(int key:map.keySet()){
            if(map.get(key)<maxi){
                maxi=map.get(key);
                r=key;
            }

        }
        return r;
    }
}