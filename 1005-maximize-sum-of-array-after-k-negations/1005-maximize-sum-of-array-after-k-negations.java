class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
        }
        while(k-->0){
            int val=pq.poll();
            pq.add(-val);
        }
        int sum=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
}