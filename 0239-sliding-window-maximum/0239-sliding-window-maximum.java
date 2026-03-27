class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        int i = 0, j = 0;
        while (j < n) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) {
                dq.pollLast();
            }
            dq.offerLast(j);
            if (!dq.isEmpty() && dq.peekFirst() < i) {
                dq.pollFirst();
            }
            if (j - i + 1 == k) {
                ans[i] = nums[dq.peekFirst()];
                i++;
            }
            j++;
        }
        
        return ans;
    }
}