import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int maxi = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxi = i + 1;
            }
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxi = Math.max(maxi, len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxi;
    }
}
