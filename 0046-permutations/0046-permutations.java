class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        helper(nums, ans, new ArrayList<>(), flag);
        return ans;
    }

    private void helper(int[] arr, List<List<Integer>> ans, List<Integer> ds, boolean[] flag) {
        if (ds.size() == arr.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                ds.add(arr[i]);
                helper(arr, ans, ds, flag);
                ds.remove(ds.size() - 1);
                flag[i] = false;
            }
        }
    }
}
