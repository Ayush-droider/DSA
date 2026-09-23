class Solution {
    public int maximizeSum(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int num:nums){
            pq.add(num);
        }
        int sum=0;
        while(k-->0){
            int max=pq.poll();
            sum+=max;
            pq.add(max+1);
        }
        return sum;
    }
}