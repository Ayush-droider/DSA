class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int size = s.length();
        if (size == 0) return 0;
        
        int maxi = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while (j < size) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (j - i + 1 > map.size()) {
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                i++;
            }

            if (j - i + 1 == map.size()) {
                maxi = Math.max(maxi, j - i + 1);
            }
            j++;
        }
        return maxi;
    }
}
