class Solution {
    public int[] findOriginalArray(int[] changed) {
        if ((changed.length) % 2 != 0) return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < changed.length; i++) {
            int x = changed[i];
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Arrays.sort(changed);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < changed.length; i++) {
            int x = changed[i];
            if (map.get(x) == 0) continue;
            int twice = x * 2;
            if (!map.containsKey(twice) || map.get(twice) == 0) {
                return new int[]{};
            }
            result.add(x);
            map.put(x, map.get(x) - 1);
            map.put(twice, map.get(twice) - 1);
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
