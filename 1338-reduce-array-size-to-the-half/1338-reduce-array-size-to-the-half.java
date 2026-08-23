class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:arr){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        List<Integer> list=new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        int n=arr.length;
        int half=n/2;
        int count=0;
        for(int val:list){
            count++;
            n=n-val;
            if(n<=half)break;
        }
        return count;
    }
}