class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        int i = 0, j = 0;
        
        while (j < n) {
            if (arr[j] < 0) {
                q.add(arr[j]);
            }
            
            if (j - i + 1 == k) {
                if (q.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(q.peek());
                }
            
                if (!q.isEmpty() && arr[i] == q.peek()) {
                    q.poll();
                }
                
                i++;
            }
            j++;
        }
        
        return ans;
    }
}
