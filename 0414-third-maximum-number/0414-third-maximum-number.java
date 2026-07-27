class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num))continue;
            set.add(num);
            pq.offer(num);
            if(pq.size()>3){
                set.remove(pq.poll());
            }
        }
        if(pq.size()==3)return pq.peek();
        while(pq.size()>1)pq.poll();
        return pq.peek();
    }
}