class Solution {
    public int longestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;
        Arrays.sort(arr);
        int curr = 1;
        int maxi = Intege;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) continue; 
            if (arr[i] == arr[i - 1] + 1) {
                curr++;
            } else {
                maxi = Math.max(maxi, curr);
                curr = 1;
            }
        }
        return Math.max(maxi, curr);
    }
}