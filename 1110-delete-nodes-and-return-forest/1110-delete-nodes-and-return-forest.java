/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode> list = new ArrayList<>();
    Set<Integer> set;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        for (int x : to_delete) {
            set.add(x);
        }
        helper(root, true);
        return list;
    }

    private TreeNode helper(TreeNode node, boolean isRoot) {
        if (node == null) return null;
        boolean isDeleted = set.contains(node.val);
        if (isRoot && !isDeleted) {
            list.add(node);
        }
        node.left = helper(node.left, isDeleted);
        node.right = helper(node.right, isDeleted);
        return isDeleted ? null : node;
    }
}