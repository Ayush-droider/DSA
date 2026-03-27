class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        int i = 0;
        for (int j = 0; j < n; j++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) {
                dq.pollLast();
            }
            dq.offerLast(j);
            if (dq.peekFirst() <= j - k) {
                dq.pollFirst();
            }
            if (j >= k - 1) {
                res[i++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}