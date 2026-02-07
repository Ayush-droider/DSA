class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int size = arr.length;
        int i = 0, j = 0;
        while (j < size) {
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[j]) {
                dq.pollLast();
            }
            dq.offerLast(j);
            if ((j - i + 1) < k) {
                j++;
            }
            else if ((j - i + 1) == k) {
                ans.add(arr[dq.peekFirst()]);
                if (dq.peekFirst() == i) {
                    dq.pollFirst();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
