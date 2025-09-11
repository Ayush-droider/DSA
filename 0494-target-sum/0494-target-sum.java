class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return Targ(0, nums, target);
    }

    private int Targ(int idx, int[] arr, int target) {
        if (idx == arr.length) {
            if(target==0){
                return 1;
            }
            return 0;
        }
        int left = Targ(idx + 1, arr, target - arr[idx]);
        int right = Targ(idx + 1, arr, target + arr[idx]);
        return left + right;
    }
}
