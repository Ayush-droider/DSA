import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>(); // 
        Arrays.sort(nums); 
        subSet(0, nums, ans, new ArrayList<>());
        return new ArrayList<>(ans); 
    }

    private void subSet(int idx, int[] arr, Set<List<Integer>> ans, List<Integer> ds) {
        if (idx == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(arr[idx]);
        subSet(idx + 1, arr, ans, ds);
        ds.remove(ds.size() - 1);
        subSet(idx + 1, arr, ans, ds);
    }
}
