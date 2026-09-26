class Solution {
    private class Pair{
        int num;
        int count;

        Pair(int num,int count){
            this.num=num;
            this.count=count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> a.count-b.count);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            pq.offer(new Pair(entry.getKey(), entry.getValue()));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().num;
        }

        return ans;
    }
}