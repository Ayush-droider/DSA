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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        if (xx == null || yy == null) return false;

        return (level(root, xx, 0) == level(root, yy, 0)) 
                && (!isSibling(root, xx, yy));
    }

    public TreeNode findNode(TreeNode root, int x) {
        if (root == null) return null;
        if (root.val == x) return root;
        TreeNode left = findNode(root.left, x);
        if (left != null) return left;
        return findNode(root.right, x);
    }

    public boolean isSibling(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) return false;

        boolean check = false;
        if (root.left != null && root.right != null) {
            check = (root.left == a && root.right == b) || (root.left == b && root.right == a);
        }

        return check || isSibling(root.left, a, b) || isSibling(root.right, a, b);
    }

    public int level(TreeNode root, TreeNode target, int lev) {
        if (root == null) return -1;
        if (root == target) return lev;

        int l = level(root.left, target, lev + 1);
        if (l != -1) return l;

        return level(root.right, target, lev + 1);
    }
}
