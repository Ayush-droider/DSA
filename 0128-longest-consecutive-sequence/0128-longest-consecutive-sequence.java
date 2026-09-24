class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int n : set) {
            map.put(n, new ArrayList<>());
        }
        int maxi = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int current = n;
                while (set.contains(current)) {
                    map.get(n).add(current);
                    current++;
                }
                maxi = Math.max(maxi, map.get(n).size());
            }
        }
        return maxi;
    }
}