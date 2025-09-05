// User function Template for Java

class Solution {
    public Node sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
     private Node buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        Node node = new Node(nums[mid]);
        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);
        return node;
    }
}